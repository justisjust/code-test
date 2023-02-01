package com.hzb.test;

import com.alibaba.fastjson.JSON;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName TestWeek.java
 * @Description TODO
 * @createTime 2022年04月07日 21:29:00
 */
public class TestRef {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        for (int i = 0; i < 2; i++) {
            user.setName("aa" + i);
            list.add(user);
        }

        System.out.println(Month.JANUARY.getValue());
        System.out.println(Month.AUGUST.getValue());

        System.out.println(JSON.toJSONString(list));
    }

    static class User{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
