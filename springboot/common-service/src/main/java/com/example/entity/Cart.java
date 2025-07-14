package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("cart")
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(type = IdType.AUTO)

    private Integer id;
    private Integer userId;
    private Integer businessId;
    private Integer goodsId;
    private Integer num;
} 