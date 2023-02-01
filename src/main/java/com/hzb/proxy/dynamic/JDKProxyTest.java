package com.hzb.proxy.dynamic;

import com.hzb.proxy.Person;
import sun.misc.ProxyGenerator;

import javax.tools.ToolProvider;
import java.io.FileOutputStream;
import java.io.IOException;
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
        Person instance = new Bangnigou<Person>().getInstance(new Wangwu());
        instance.buy();

        try {
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("D:\\workspace\\code-test\\target\\classes\\generated\\$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try {
//            Method method = instance.getClass().getMethod("buy", null);
//            method.invoke(instance);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        ToolProvider.getSystemJavaCompiler();
    }
}
