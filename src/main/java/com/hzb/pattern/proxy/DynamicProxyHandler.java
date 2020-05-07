package com.hzb.pattern.proxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-05-06 19:19
 * @Version 1.0
 */
@Data
public class DynamicProxyHandler implements InvocationHandler {

    private Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(JSON.toJSONString(args));
        System.out.println("before");
        method.invoke(target, args);
        System.out.println("after");
        return null;
    }

    public Object newInstance() {
        Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return instance;
    }

    public static void main(String[] args) {
        IUserService instance = (IUserService) new DynamicProxyHandler(new UserService()).newInstance();
        instance.select("张三");

    }
}
