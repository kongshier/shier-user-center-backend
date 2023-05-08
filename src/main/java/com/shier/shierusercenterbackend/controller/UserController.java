package com.shier.shierusercenterbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shier.shierusercenterbackend.model.domian.User;
import com.shier.shierusercenterbackend.model.request.UserLoginRequest;
import com.shier.shierusercenterbackend.model.request.UserRegisterRequest;
import com.shier.shierusercenterbackend.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.shier.shierusercenterbackend.constant.UserConstant.ADMIN_ROLE;
import static com.shier.shierusercenterbackend.constant.UserConstant.USER_LOGIN_STATE;

/**
 * @author Shier
 * CreateTime 2023/5/6 22:16
 * 用户控制器接口
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户注册请求接口
     *
     * @param userRegisterRequest
     * @return
     */
    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return null;
        }
        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    /**
     * 用户登录请求接口
     *
     * @param userLoginRequest
     * @param request          请求对象
     * @return
     */
    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        return userService.userLogin(userAccount, userPassword, request);
    }

    /**
     * 查询用户接口
     *
     * @param username
     * @return
     */
    @GetMapping("/search")
    public List<User> searchUsers(String username, HttpServletRequest request) {
        // 管理员校验
        if (!isAdmin(request)) {
            return new ArrayList<>();
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like("username", username);
        }
        List<User> userList = userService.list(queryWrapper);
        //userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
        return userList.stream().map(userService::getSafetyUser).collect(Collectors.toList());
    }

    /**
     * 删除用户接口
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public boolean deleteUser(@RequestBody long id, HttpServletRequest request) {
        if (!isAdmin(request)) {
            return false;
        }
        if (id < 0) {
            return false;
        }
        return userService.removeById(id);
    }

    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
    private boolean isAdmin(HttpServletRequest request) {
        // 管理员校验
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;
        //return user != null && user.getUserRole() == ADMIN_ROLE;
        if (user == null || user.getUserRole() != ADMIN_ROLE) {
            return false;
        }
        return true;
    }
}
