package com.hzb.proxy.dynamic;

import com.hzb.proxy.Person;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-31 14:47
 * @Version 1.0
 */
public class Wangwu implements Person {
    @Override
    public void buy() {
        System.out.println("我是王五，我要999感冒灵");
    }
}
