package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created with IntelliJ IDEA.
 * UserService
 *
 * @author lijc
 * @date 2018/1/25 17:06
 */
public interface IUserService {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     *
     * @return
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 注册
     *
     * @param user User
     *
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 校验
     *
     * @param str
     * @param type
     *
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);
}
