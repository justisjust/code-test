package com.hzb.springbootdemo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-30 16:50
 * @Version 1.0
 */
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public void executeException(Exception e) {

        System.out.println("处理异常" + e.getMessage());
    }

}
