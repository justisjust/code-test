package com.hzb.netty.rpc.consumer.proxy;

import com.hzb.netty.rpc.protocol.InvokerProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 23:08
 * @Version 1.0
 */
public class RpcProxy {


    public static <T> T create(Class<?> clazz) {
        T instance = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz },
                new MethodProxy(clazz));
        return instance;
    }


    private static class MethodProxy implements InvocationHandler {

        private Class<?> clazz;

        public MethodProxy(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            } else {
                return prcInvoker(proxy, method, args);
            }
        }

        private Object prcInvoker(Object proxy, Method method, Object[] args) {
            InvokerProtocol req = new InvokerProtocol();
            req.setClassName(this.clazz.getName());
            req.setMethod(method.getName());
            req.setParams(method.getParameterTypes());
            req.setValues(args);

            final RpcProxyHandler proxyHandler = new RpcProxyHandler(req);
            //发起网络请求
            NioEventLoopGroup workGroup = new NioEventLoopGroup();

            Bootstrap client = new Bootstrap();
            client.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //在netty中，将所有的业务都归总在一个队列中
                            //pipeline
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            pipeline.addLast(new LengthFieldPrepender(4));

                            pipeline.addLast("encoder", new ObjectEncoder());
                            pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE,
                                    ClassResolvers.cacheDisabled(null)));

                            //1.注册每个对象
                            //2.记录位置
                            pipeline.addLast(proxyHandler);
                        }
                    });
            try {
                ChannelFuture future = client.connect("localhost", 8080).sync();
//                future.channel().writeAndFlush(req).sync();
                future.channel().closeFuture().sync();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() +"---" +  "guanbi");
                workGroup.shutdownGracefully();
            }
            return proxyHandler.getResponse();
        }
    }
}
