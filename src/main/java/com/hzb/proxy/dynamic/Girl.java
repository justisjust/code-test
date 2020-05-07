package com.hzb.proxy.dynamic;

import com.hzb.proxy.Person;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-31 14:47
 * @Version 1.0
 */
public class Girl implements Person {
    @Override
    public void find() {
        System.out.println("find love");
    }
}
