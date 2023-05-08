package com.shier.shierusercenterbackend.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shier
 * CreateTime 2023/5/6 22:28
 *
 * 用户注册请求体参数
 */
@Data
public class UserRegisterRequest implements Serializable {

    /**
     * 防止序列化出现冲突
     */
    private static final long serialVersionUID = 3553317334228624372L;

    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 校验密码
     */
    private String checkPassword;
}
