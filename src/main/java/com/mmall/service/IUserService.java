package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created with IntelliJ IDEA.
 * <功能描述>
 *
 * @author lijc
 * @date 2018/1/25 17:06
 */
public interface IUserService {
    ServerResponse<User> userLogin(String username, String password);
}
