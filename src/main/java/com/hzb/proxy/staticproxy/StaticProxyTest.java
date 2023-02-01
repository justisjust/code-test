package com.hzb.proxy.staticproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-31 14:22
 * @Version 1.0
 */
public class StaticProxyTest {

    public static void main(String[] args) {
//        new Father(new Son()).find();
        Wuye wuye = new Wuye(new Zhangsan());
        try {
            Method method = wuye.getClass().getMethod("buy", null);
            method.invoke(wuye);
//            method.invoke(father, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
