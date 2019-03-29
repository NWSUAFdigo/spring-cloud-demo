package com.hht.controller;

import com.hht.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private FeignInterface feignInterface;

    @GetMapping("/sayHello")
    public String sayHi(@RequestParam String name) {
        return feignInterface.sayHi(name);
    }
}
