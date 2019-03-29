package com.hht.controller;

import com.hht.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private FeignInterface feignInterface;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @GetMapping("/sayHello")
    public String sayHi(@RequestParam String name) {
        return feignInterface.sayHi(name);
    }

    @GetMapping(path = "/userInfo")
    public String getUserInfo() {
        return "name = " + name + ", age = " + age;
    }
}
