package com.example.goods.dto;

import com.example.entity.Goods;
import lombok.Data;


@Data
public class GoodsDTO extends Goods {

    private String BusinessName;
    private String CategoryName;

    public GoodsDTO(Goods goods) {
        super(goods);
    }

}
