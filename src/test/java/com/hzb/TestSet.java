package com.hzb;

import lombok.Data;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-28 11:22
 * @Version 1.0
 */
public class TestSet {

    @Data
    public static class Bean{
        String name = "sss";
    }

    public static void main(String[] args) {
        Bean bean = new Bean();
        bean.setName("f");
        System.out.println(bean.getName());
    }
}
