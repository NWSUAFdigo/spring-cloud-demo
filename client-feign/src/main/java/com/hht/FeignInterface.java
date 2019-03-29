package com.hht;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "client1", fallback = FeignHystricx.class)
@Repository
public interface FeignInterface {
    @GetMapping("/hi")
    String sayHi(@RequestParam("name") String name);
}
