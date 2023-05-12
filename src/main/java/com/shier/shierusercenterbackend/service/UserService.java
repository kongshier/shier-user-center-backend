package com.shier.shierusercenterbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shier.shierusercenterbackend.model.domain.User;
import com.shier.shierusercenterbackend.model.request.UserSearchRequest;
import com.shier.shierusercenterbackend.model.request.UserUpdatePasswordRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Shier
 * 用户服务接口
 * @createDate 2023-05-05 16:48:11
 */
public interface UserService extends IService<User> {


    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @param userCode      用户编号
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String userCode);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request      读写信息
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 修改密码
     *
     * @param updatePasswordRequest
     * @param request
     */
    boolean updateUserPassword(UserUpdatePasswordRequest updatePasswordRequest, HttpServletRequest request);

    /**
     * 分页条件
     * @param searchRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserSearchRequest searchRequest);
}
