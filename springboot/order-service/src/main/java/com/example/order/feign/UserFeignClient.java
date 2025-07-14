package com.example.order.feign;

import com.example.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", fallback = UserFeignFallback.class)
public interface UserFeignClient {
    
    @GetMapping("/user/selectById/{id}")
    Result selectById(@PathVariable("id") Integer id);
} 