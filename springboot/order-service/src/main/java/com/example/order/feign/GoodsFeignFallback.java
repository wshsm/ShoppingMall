package com.example.order.feign;

import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.order.dto.GoodsDTO;
import org.springframework.stereotype.Component;

@Component
public class GoodsFeignFallback implements GoodsFeignClient {
    
    @Override
    public Result selectById(Integer id) {
        return Result.error(ResultCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public GoodsDTO getGoodsById(Integer id) {
        return null;
    }
} 