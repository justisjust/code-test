package com.hzb.netty.rpc.consumer.proxy;

import com.hzb.netty.rpc.protocol.InvokerProtocol;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 23:26
 * @Version 1.0
 */
public class RpcProxyHandler extends SimpleChannelInboundHandler {

    private Object response;

    public RpcProxyHandler(InvokerProtocol response) {
        this.response = response;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread().getName() + "---" + "正在连接... ");


        ctx.writeAndFlush(response).sync();
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread().getName() + "---" + "连接关闭! ");
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(Thread.currentThread().getName() + "---" + " 收到数据! ");
        response = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("client is exception");

    }

    public Object getResponse() {
        return response;
    }
}
