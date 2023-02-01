package com.hzb.proxy.staticproxy;

import com.hzb.proxy.Person;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-31 14:20
 * @Version 1.0
 */
public class Zhangsan implements Person {
    @Override
    public void buy() {
        System.out.println("我要买连花清瘟胶囊*10");
    }
}
