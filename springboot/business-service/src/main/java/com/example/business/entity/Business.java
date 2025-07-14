package com.example.business.entity;

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
@TableName("business")
public class Business implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /** 商家名称 */
    private String name;
    /** 商家描述 */
    private String description;
    /** 商家地址 */
    private String address;
    /** 商家电话 */
    private String phone;
    /** 商家邮箱 */
    private String email;
    /** 商家状态 */
    private String status;
    /** 创建时间 */
    private String createTime;
    /** 更新时间 */
    private String updateTime;
} 