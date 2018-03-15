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
     * @return
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 注册
     *
     * @param user User
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 校验
     *
     * @param str
     * @param type
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 获取密码提示问题
     *
     * @param username 用户名
     * @return
     */
    ServerResponse<String> selectQuestion(String username);

    /**
     * 检验问题答案
     *
     * @param username 用户名
     * @param question 问题
     * @param answer   问题答案
     * @return
     */
    ServerResponse<String> checkAnswer(String username, String question, String answer);

    /**
     * 更新密码
     *
     * @param username    用户名
     * @param passwordNew 新密码
     * @param forgetToken token
     * @return
     */
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    /**
     * 修改密码
     *
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @param user        用户
     * @return
     */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    /**
     * 更新用户信息
     *
     * @param user 用户
     * @return
     */
    ServerResponse<User> updateUserInfo(User user);

    /**
     * 获取用户信息
     *
     * @param userId ID
     * @return
     */
    ServerResponse<User> getInformation(Integer userId);

    /**
     * 判断用户角色是否是管理员
     *
     * @param user User
     * @return
     */
    ServerResponse checkAdminRole(User user);
}
