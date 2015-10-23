/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author leha
 */
@Configuration
@Order(11111)
public class RootServletConfig {
    
    @Autowired
    protected ApplicationContext applicationContext;

    /*
    public DispatcherServlet dispatcherServlet() {

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setParent(applicationContext);
        webContext.register(RootConfig.class);
        //webContext.register(ThymeleafAutoConfiguration.class);
        //webContext.scan("com.example.m1");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        return dispatcherServlet;

    }
    */

    /*@Bean
    public ServletRegistrationBean rootServletRegistration() {
    ServletRegistrationBean registration = new ServletRegistrationBean(
    dispatcherServlet(), "/");
    registration.setName("root");
    
    return registration;
    }*/
}
