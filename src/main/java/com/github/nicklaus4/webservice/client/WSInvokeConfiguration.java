package com.github.nicklaus4.webservice.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ws client config
 *
 * @author weishibai
 * @date 2019/03/26 11:13 PM
 */
@Configuration
public class WSInvokeConfiguration {


    @Bean
    public JaxWsProxyFactoryBean jaxWsProxyFactoryBean() {
        return new JaxWsProxyFactoryBean();
    }
}
