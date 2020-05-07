package com.hzb.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-30 17:38
 * @Version 1.0
 */
public class TestPrintGCDetail {


    private static byte[] bytes = new byte[1024*1024];

    /**
     * -Xms10m -Xmx20m -verbose:gc -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                byte[] bytes = new byte[1024*1024];
                list.add(bytes);
            }
        }finally {
            System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
            System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
            System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        }


        System.gc();
    }
}
