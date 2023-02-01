package com.hzb.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-31 14:48
 * @Version 1.0
 */
public class Bangnigou<T> implements InvocationHandler {

    private T target;

    public T getInstance(T target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        end();
        return invoke;
    }

    private void before() {
        System.out.println("开始");
    }

    private void end() {
        System.out.println("结束");
    }
}
