package com.example.order.entity;

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
@TableName("orders")
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /** 订单号 */
    private String orderNo;
    /** 用户ID */
    private Integer userId;
    /** 商品ID */
    private Integer goodsId;
    /** 商品数量 */
    private Integer quantity;
    /** 订单总价 */
    private Double totalPrice;
    /** 订单状态 */
    private String status;
    /** 收货地址 */
    private String address;
    /** 收货人姓名 */
    private String receiverName;
    /** 收货人电话 */
    private String receiverPhone;
    /** 创建时间 */
    private String createTime;
    /** 更新时间 */
    private String updateTime;
} 