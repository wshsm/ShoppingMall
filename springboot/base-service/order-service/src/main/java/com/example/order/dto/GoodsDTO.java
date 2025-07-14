package com.example.order.dto;

import lombok.Data;

@Data
public class GoodsDTO {
    private Integer id;
    private String name;
    private String img;
    private String unit;
    private Double price;
    private Integer inventory;
} 