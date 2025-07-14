package com.example.order.feign;

import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class GoodsFeignFallback implements GoodsFeignClient {
    
    @Override
    public Result selectById(Integer id) {
        return Result.error(ResultCodeEnum.SYSTEM_ERROR);
    }
} 