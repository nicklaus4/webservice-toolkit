package com.github.nicklaus4.webservice.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.nicklaus4.webservice.client.WSInvokeConfiguration;
import com.github.nicklaus4.webservice.demo.service.UserService;
import com.github.nicklaus4.webservice.demo.service.impl.UserServiceImpl;
import com.github.nicklaus4.webservice.server.WSExportConfiguration;

/**
 * test ws configuration
 *
 * @author weishibai
 * @date 2019/03/26 10:30 PM
 */
@Configuration
@Import({WSExportConfiguration.class, WSInvokeConfiguration.class})
public class TestWSConfiguration {

    @Bean(name = "userService")
    public UserService userService() {
        return new UserServiceImpl();
    }

}
