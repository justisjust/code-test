package com.hzb.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年05月15日 17:28:00
 */
public class Test {

    public static void main(String[] args) {
        String payment = "jd";
        Payment strategy = new JdStrategy();
        if(payment.equals("jd")) {
            strategy = new JdStrategy();
        }else if(payment.equals("wechat")) {
            strategy = new WechatStrategy();
        }
//        strategy.doPay();

        System.out.println("================");

         map.get(payment).doPay();

    }

    static Map<String, Payment> map = new HashMap<>();
    static {
        map.put("jd", new JdStrategy());
        map.put("wechat", new JdStrategy());
    }
}
