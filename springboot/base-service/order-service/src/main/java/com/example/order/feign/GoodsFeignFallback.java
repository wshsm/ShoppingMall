package com.example.order.feign;

import com.example.common.R;
import com.example.common.enums.ResultCodeEnum;
import com.example.order.dto.GoodsDTO;
import org.springframework.stereotype.Component;

@Component
public class GoodsFeignFallback implements GoodsFeignClient {
    
    @Override
    public R selectById(Integer id) {
        return R.error(ResultCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public GoodsDTO getGoodsById(Integer id) {
        return null;
    }
} 