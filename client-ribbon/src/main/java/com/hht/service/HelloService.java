package com.hht.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    // 添加熔断功能
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHello(String name) {
        return restTemplate.getForObject("http://client1/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "sorry #" + name + ", 当前服务出现故障...";
    }
}
