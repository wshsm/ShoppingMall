package com.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 新密码 */
    private String newPassword;
    /** 角色 */
    private String role;
    /** 昵称 */
    private String name;
    /** 头像 */
    private String avatar;
    /** 电话 */
    private String phone;
    /** 邮箱 */
    private String email;
    /** 地址 */
    private String address;
}
