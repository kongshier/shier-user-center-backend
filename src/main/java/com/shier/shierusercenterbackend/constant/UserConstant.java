package com.shier.shierusercenterbackend.constant;

/**
 * @author Shier
 * CreateTime 2023/5/6 23:27
 * 用户常量
 */
public interface UserConstant {
    /**
     * 用户登录态
     */
    String USER_LOGIN_STATE = "userLoginState";

    /**
     * 默认权限 user-普通用户
     */
    String  DEFAULT_ROLE ="user";

    /**
     * 管理员权限  admin-管理员
     */
    String ADMIN_ROLE = "admin";

    /**
     * ban-封号
     */
    String USER_BAN = "ban";
}
