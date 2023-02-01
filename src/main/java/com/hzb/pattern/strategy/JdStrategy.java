package com.hzb.pattern.strategy;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName JdPaymentStrategy.java
 * @Description TODO
 * @createTime 2022年05月15日 17:25:00
 */
public class JdStrategy implements Payment{
    @Override
    public void doPay() {
        System.out.println("I am joy.");
    }
}
