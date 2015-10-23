/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.m1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author leha
 */
@Configuration
public class M1ServletConfig {

    @Autowired
    protected ApplicationContext applicationContext;

    public DispatcherServlet dispatcherServlet() {

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setParent(applicationContext);
        webContext.register(M1Config.class);
        //webContext.register(ThymeleafAutoConfiguration.class);
        webContext.scan("com.example.m1");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        return dispatcherServlet;

    }

    @Bean
    public ServletRegistrationBean m1ServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet(), "/m1/*");
        registration.setName("m1");

        return registration;
    }

}
