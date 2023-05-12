package com.shier.shierusercenterbackend.model.request;

import com.shier.shierusercenterbackend.common.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户更新请求
 *
 * @author Shier
 */
@Data
public class UserSearchRequest extends PageRequest implements Serializable {

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 账号
     */
    private String userAccount;


    /**
     * 性别 男 女
     */
    private String gender;


    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态  0-正常 1-注销 2-封号
     */
    private Integer userStatus;


    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user-普通用户 admin-管理员 ban-封号
     */
    private String userRole;

    /**
     * 用户编号
     */
    private String userCode;

    private static final long serialVersionUID = 1L;
}