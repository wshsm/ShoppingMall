package com.example.order.feign;

import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.order.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeignClient {
    
    @Override
    public Result selectById(Integer id) {
        return Result.error(ResultCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public AddressDTO getAddressById(Integer id) {
        return null;
    }
} 