package com.example.user.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.user.entity.Account;
import com.example.user.entity.Admin;
import com.example.user.entity.User;
import com.example.user.service.AdminService;
import com.example.user.service.BusinessService;
import com.example.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;



/**
 * 基础前端接口
 */
@RestController
public class WebController {

    @Resource
    private AdminService adminService;
    @Resource
    private BusinessService businessService;
    @Resource
    private UserService userService;

    @GetMapping("/")
    public Result hello() {
        return Result.success("访问成功");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        if (ObjectUtil.isEmpty(account.getUsername()) || ObjectUtil.isEmpty(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            Admin admin = new Admin();
            admin.setUsername(account.getUsername());
            admin.setPassword(account.getPassword());
            Admin loginAdmin = adminService.login(admin);
            if (loginAdmin == null) return Result.error(ResultCodeEnum.USER_ACCOUNT_ERROR);
            // 可根据需要将Admin转为Account返回
            account.setName(loginAdmin.getName());
            account.setRole(loginAdmin.getRole());
            account.setAvatar(loginAdmin.getAvatar());
            account.setPhone(loginAdmin.getPhone());
            account.setEmail(loginAdmin.getEmail());
            return Result.success(account);
        }
        if (RoleEnum.BUSINESS.name().equals(account.getRole())) {
            account = businessService.login(account);
            return Result.success(account);
        }
        if (RoleEnum.USER.name().equals(account.getRole())) {
            User user = new User();
            user.setUsername(account.getUsername());
            user.setPassword(account.getPassword());
            User loginUser = userService.login(user);
            if (loginUser == null) return Result.error(ResultCodeEnum.USER_ACCOUNT_ERROR);
            account.setName(loginUser.getName());
            account.setRole(loginUser.getRole());
            account.setAvatar(loginUser.getAvatar());
            account.setPhone(loginUser.getPhone());
            account.setEmail(loginUser.getEmail());
            return Result.success(account);
        }
        return Result.error(ResultCodeEnum.USER_ACCOUNT_ERROR);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            Admin admin = new Admin();
            admin.setUsername(account.getUsername());
            admin.setPassword(account.getPassword());
            admin.setName(account.getName());
            admin.setRole(account.getRole());
            admin.setAvatar(account.getAvatar());
            admin.setPhone(account.getPhone());
            admin.setEmail(account.getEmail());
            adminService.register(admin);
        }
        if (RoleEnum.BUSINESS.name().equals(account.getRole())) {
            businessService.register(account);
        }
        if (RoleEnum.USER.name().equals(account.getRole())) {
            User user = new User();
            user.setUsername(account.getUsername());
            user.setPassword(account.getPassword());
            user.setName(account.getName());
            user.setRole(account.getRole());
            user.setAvatar(account.getAvatar());
            user.setPhone(account.getPhone());
            user.setEmail(account.getEmail());
            userService.register(user);
        }
        return Result.success();
    }

    /**
     * 修改密码
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getNewPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            Admin admin = new Admin();
            admin.setUsername(account.getUsername());
            admin.setPassword(account.getNewPassword());
            adminService.updatePassword(admin);
        }
        if (RoleEnum.BUSINESS.name().equals(account.getRole())) {
            businessService.updatePassword(account);
        }
        if (RoleEnum.USER.name().equals(account.getRole())) {
            User user = new User();
            user.setUsername(account.getUsername());
            user.setPassword(account.getNewPassword());
            userService.updatePassword(user);
        }
        return Result.success();
    }

} 