package com.hzb.netty.rpc.provider;

import com.hzb.netty.rpc.api.IHelloService;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 22:06
 * @Version 1.0
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public String say(String name) {
        return "Hello : " + name;
    }
}
