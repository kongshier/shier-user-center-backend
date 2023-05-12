package com.shier.shierusercenterbackend.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shier
 * CreateTime 2023/5/11 12:24
 */
@Data
public class UserUpdatePasswordRequest implements Serializable {

    private static final long serialVersionUID = -5996345129538944393L;

    /**
     * 原密码
     */
    private String userPassword;

    /**
     * 新密码
     */
    private String newPassword;
}
