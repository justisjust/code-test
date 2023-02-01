package com.hzb.poi;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName TetsInterface.java
 * @Description TODO
 * @createTime 2022年06月20日 16:44:00
 */
public interface TestInterface {

    String param = "a";

    void getParam();

    default void printParam() {
        System.out.println(param);
    }
}
