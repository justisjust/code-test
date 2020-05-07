package com.hzb.netty.rpc.registry;

import com.hzb.netty.rpc.protocol.InvokerProtocol;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 22:28
 * @Version 1.0
 */
public class RpcRegistryHandler extends ChannelInboundHandlerAdapter {

    private Map<String, Object> registryMap = new ConcurrentHashMap<>();

    //    1.根据包名将所有class文件扫描出来（或者是配置文件），放到一个集合中
//    2.给每一个对应的class起唯一名称，作为服务名，放到容器中
//    3.当客户端请求时候，获取对应的InvokerProtocol对象
//    4.去注册好的容器中到对应的服务
//    5.通过远程调用Provider得到返回值，返回给客户端

    public RpcRegistryHandler() {

        try {
            scanClass("com.hzb.netty.rpc.provider");
            doRegistry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doRegistry()
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        if(classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            Class<?> clazz = Class.forName(className);
            String name = clazz.getInterfaces()[0].getName();

            registryMap.put(name, clazz.newInstance());
        }
    }

    private List<String> classNames = new ArrayList<>();

    private void scanClass(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {

            if(file.isDirectory()) {
                scanClass(packageName + "." + file.getName());
            } else {
                classNames.add(packageName + "." + file.getName().replace(".class", ""));
            }
        }
    }

    //    3.当客户端请求时候，获取对应的InvokerProtocol对象
    //处理请求，回调
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object result = new Object();
        try {
            InvokerProtocol request = (InvokerProtocol) msg;
            //    4.去注册好的容器中到对应的服务
            if(registryMap.containsKey(request.getClassName())) {
                Object service = registryMap.get(request.getClassName());
                Method method = service.getClass().getMethod(request.getMethod(), request.getParams());
                result = method.invoke(service, request.getValues());

            }
            //    5.通过远程调用Provider得到返回值，返回给客户端
            System.out.println("返回数据给客户端");
            TimeUnit.SECONDS.sleep(3);
            ctx.write(result);

        } catch (Exception e) {
            ctx.write("test");
        }
        ctx.flush();
        ctx.close();

    }

    //发生异常时候回调
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
