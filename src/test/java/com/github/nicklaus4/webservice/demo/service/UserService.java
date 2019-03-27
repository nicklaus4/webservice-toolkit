package com.github.nicklaus4.webservice.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.github.nicklaus4.webservice.demo.User;

/**
 * user ws
 *
 * @author weishibai
 * @date 2019/03/26 10:20 PM
 */
@WebService
public interface UserService {

    @WebMethod
    String getName(@WebParam(name = "userId") String userId);
    @WebMethod
    User getUser(String userId);
}