package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * 用户
 *
 * @author lijc
 * @date 2018/1/25 17:06
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> serverResponse = iUserService.userLogin(username, password);
        if (serverResponse.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, serverResponse);
        }
        return serverResponse;
    }
}
