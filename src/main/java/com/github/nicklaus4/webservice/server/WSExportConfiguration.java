package com.github.nicklaus4.webservice.server;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * ws export configuration
 *
 * @author weishibai
 * @date 2019/03/26 10:49 PM
 */
@Configuration
public class WSExportConfiguration {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private Environment env;

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), env.getProperty("ws-mapping-url"));
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(SpringBus springBus) {
        EndpointImpl endpoint = new EndpointImpl(springBus, context.getBean(env.getProperty("expose-ws-bean-name")));
        endpoint.publish(env.getProperty("expose-addr"));
        return endpoint;
    }

}
