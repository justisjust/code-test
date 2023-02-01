package com.hzb;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName TestFor.java
 * @Description TODO
 * @date 2023年01月06日 21:51:00
 */
public class TestFor {


    public static void main(String[] args) {
        int[] res = new int[5];
        for (int i = 0; i < 5; i++) {
            res[i] += i;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(res[i]);
        }
    }

}
