package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
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
    public ServerResponse<User> userLogin(String username, String password) {
        int result = userMapper.checkUsername(username);
        if (result == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        // TODO MD5加密
        User user = userMapper.userLogin(username, password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccess("登录成功", user);
    }
}
