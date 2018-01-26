package com.mmall.service.impl;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import com.mmall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * <功能描述>
 *
 * @author lijc
 * @date 2018/1/25 17:08
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        ServerResponse<String> serverResponse = this.checkValid(username, Const.USERNAME);
        if (!serverResponse.isSuccess()) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.userLogin(username, md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccess("登录成功", user);
    }

    @Override
    public ServerResponse<String> register(User user) {
        ServerResponse<String> serverResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!serverResponse.isSuccess()) {
            return serverResponse;
        }
        serverResponse = this.checkValid(user.getEmail(), Const.EMAIL);
        if (!serverResponse.isSuccess()) {
            return serverResponse;
        }

        user.setRole(Const.Role.ROLE_CUSTOMER);
        // 密码MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int resultCount = userMapper.insert(user);

        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isBlank(type)) {
            return ServerResponse.createByErrorMessage("参数传递错误");
        }
        if (Const.USERNAME.equals(type)) {
            int result = userMapper.checkUsername(str);
            if (result > 0) {
                return ServerResponse.createByErrorMessage("用户名已存在");
            }
        }
        if (Const.EMAIL.equals(type)) {
            int result = userMapper.checkEmail(str);
            if (result > 0) {
                return ServerResponse.createByErrorMessage("该邮箱已被注册");
            }
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }
}
