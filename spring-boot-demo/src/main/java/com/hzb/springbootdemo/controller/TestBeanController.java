package com.hzb.springbootdemo.controller;

import com.hzb.format.FormatProcess;
import com.hzb.springbootdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-28 11:29
 * @Version 1.0
 */
@RequestMapping("/test")
@RestController
public class TestBeanController {

    @GetMapping
    public void savePerson(Person person) {
        System.out.println(person.getName());
    }

    @Autowired
    private FormatProcess formatProcess;

    @GetMapping("format")
    public String format() {
        String format = formatProcess.format(new Person());
        int i = 1 / 0;
        return format;
    }

}
