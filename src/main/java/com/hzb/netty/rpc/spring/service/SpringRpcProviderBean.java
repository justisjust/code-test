package com.hzb.netty.rpc.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName SpringRpcProviderBean.java
 * @Description TODO
 * @createTime 2022年05月29日 15:36:00
 */
public class SpringRpcProviderBean implements InitializingBean, BeanPostProcessor {
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
