package com.hzb.proxy.staticproxy;

import com.hzb.proxy.Person;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-31 14:21
 * @Version 1.0
 */
public class Wuye implements Person {

    private Zhangsan zhangsan;

    public Wuye(Zhangsan zhangsan) {
        this.zhangsan = zhangsan;
    }

    @Override
    public final void buy() {
        System.out.println("收集信息");
        zhangsan.buy();
        System.out.println("按需发放");
    }
}
