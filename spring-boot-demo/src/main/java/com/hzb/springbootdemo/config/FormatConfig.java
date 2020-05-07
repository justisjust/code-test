//package com.hzb.springbootdemo.config;
//
//import com.hzb.format.FormatProcess;
//import com.hzb.format.JsonFormat;
//import com.hzb.format.StringFormat;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
///**
// * @Description TODO
// * @Author haozhenbo
// * @Date 2020-04-28 11:53
// * @Version 1.0
// */
//@Configuration
//public class FormatConfig {
//
//    @Bean
//    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
//    @Primary
//    public FormatProcess getStringFormat() {
//        return new StringFormat();
//    }
//
//    @Bean
//    public FormatProcess getJSONFormat() {
//        return new JsonFormat();
//    }
//
//}
