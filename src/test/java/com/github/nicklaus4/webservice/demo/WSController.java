package com.github.nicklaus4.webservice.demo;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.github.nicklaus4.webservice.demo.service.UserService;

/**
 * invoke ws service
 *
 * @author weishibai
 * @date 2019/03/26 11:17 PM
 */
public class WSController {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/ws/user?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(UserService.class);

        UserService userService = (UserService) jaxWsProxyFactoryBean.create();
        System.out.println(userService.getUser("123"));
    }

}
