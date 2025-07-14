package com.example.order.feign;

import com.example.common.Result;
import com.example.order.dto.GoodsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "goods-service", fallback = GoodsFeignFallback.class)
public interface GoodsFeignClient {
    
    @GetMapping("/goods/selectById/{id}")
    Result selectById(@PathVariable("id") Integer id);

    @GetMapping("/goods/{id}")
    GoodsDTO getGoodsById(@PathVariable("id") Integer id);
} 