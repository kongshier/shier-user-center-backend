package com.shier.shierusercenterbackend.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shier
 * CreateTime 2023/5/6 22:28
 * 用户登录请求体参数
 */
@Data
public class UserLoginRequest implements Serializable {

    /**
     * 防止序列化出现冲突
     */
    private static final long serialVersionUID = -7466568631126993829L;

    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户密码
     */
    private String userPassword;

}
