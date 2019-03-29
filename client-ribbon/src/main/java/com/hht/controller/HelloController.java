package com.hht.controller;

import com.hht.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @GetMapping(path = "/sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }

    @GetMapping(path = "/userInfo")
    public String getUserInfo() {
        return "name = " + name + ", age = " + age;
    }
}
