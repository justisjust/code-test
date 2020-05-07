package com.hzb.proxy.staticproxy;

import com.hzb.proxy.Person;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-31 14:20
 * @Version 1.0
 */
public class Son implements Person {
    @Override
    public void find() {
        System.out.println("need job");
    }
}
