package com.hzb.netty.rpc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName RemoteSevice.java
 * @Description TODO
 * @createTime 2022年05月29日 15:22:00
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Autowired
public @interface RemoteService {
}
