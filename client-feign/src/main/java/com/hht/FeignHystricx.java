package com.hht;

import org.springframework.stereotype.Component;

@Component
public class FeignHystricx implements FeignInterface {
    @Override
    public String sayHi(String name) {
        return "sorry #" + name + "! 服务出现故障...";
    }
}
