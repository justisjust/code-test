package com.hzb.pattern.strategy;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName WechatStrategy.java
 * @Description TODO
 * @createTime 2022年05月15日 17:26:00
 */
public class WechatStrategy implements Payment{
    @Override
    public void doPay() {
        System.out.println("我是微信");
    }
}
