package com.github.nicklaus4.webservice.demo.service.impl;

import javax.jws.WebService;

import com.github.nicklaus4.webservice.demo.User;
import com.github.nicklaus4.webservice.demo.service.UserService;

/**
 * user ws impl
 *
 * @author weishibai
 * @date 2019/03/26 10:24 PM
 */
@WebService(targetNamespace = "http://service.demo.webservice.nicklaus4.github.com/"
        , endpointInterface = "com.github.nicklaus4.webservice.demo.service.UserService")
public class UserServiceImpl implements UserService {

    public String getName(String userId) {
        return "nicklaus";
    }

    public User getUser(String userId) {
        final User user = new User();
        user.setId(userId);
        user.setName("nicklaus");
        return user;
    }

}
