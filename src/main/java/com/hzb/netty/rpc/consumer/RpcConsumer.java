package com.hzb.netty.rpc.consumer;

import com.hzb.netty.rpc.api.IHelloService;
import com.hzb.netty.rpc.consumer.proxy.RpcProxy;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 23:06
 * @Version 1.0
 */
public class RpcConsumer {

    public static void main(String[] args) {
        IHelloService helloService = RpcProxy.create(IHelloService.class);
        String content = helloService.say("tt");
        System.out.println(Thread.currentThread().getName() + "---" + content);
    }
}
