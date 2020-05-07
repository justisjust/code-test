package com.hzb.proxy.dynamic;

import com.hzb.proxy.Person;

import javax.tools.ToolProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-31 14:57
 * @Version 1.0
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        Person instance = new Meipo<Person>().getInstance(new Girl());
//        instance.find();
        try {
            Method method = instance.getClass().getMethod("find", null);
            method.invoke(instance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ToolProvider.getSystemJavaCompiler();
    }
}
