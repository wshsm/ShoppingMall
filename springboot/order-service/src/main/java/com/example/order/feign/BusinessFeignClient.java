package com.example.order.feign;

import com.example.order.dto.BusinessDTO;
import com.example.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "business-service")
public interface BusinessFeignClient {
    @GetMapping("/business/{id}")
    BusinessDTO getBusinessById(@PathVariable("id") Integer id);

} 