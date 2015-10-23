/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.m1;

import java.util.Collection;
import java.util.Collections;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 *
 * @author leha
 */
@Configuration
@EnableWebMvc
public class M1Config {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(M1Config.class);

    @Autowired
    private ThymeleafProperties properties;

    @Autowired
    private SpringResourceResourceResolver resourceResolver;

    public ITemplateResolver operatorsTemplateResolver() {
        TemplateResolver resolver = new TemplateResolver();
        resolver.setResourceResolver(resourceResolver);
        resolver.setPrefix(this.properties.getPrefix() + "m1/");
        resolver.setSuffix(this.properties.getSuffix());
        resolver.setTemplateMode(this.properties.getMode());
        resolver.setCharacterEncoding(this.properties.getEncoding());
        resolver.setCacheable(this.properties.isCache());
        logger.debug("m1 templates resolver !!! ");

        return resolver;
    }

    @Autowired(required = false)
    private final Collection<IDialect> dialects = Collections.emptySet();

    public SpringTemplateEngine m1TemplateEngine() {

        logger.debug("m1 template engine !!!");

        SpringTemplateEngine engine = new SpringTemplateEngine();

        engine.addTemplateResolver(operatorsTemplateResolver());

        for (IDialect dialect : this.dialects) {
            engine.addDialect(dialect);
        }

        return engine;
    }

    @Bean
    public ViewResolver viewResolver() {

        logger.debug("m1 m1 view resolver");

        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(m1TemplateEngine());
        resolver.setCharacterEncoding(this.properties.getEncoding());
        resolver.setContentType(appendCharset(this.properties.getContentType(),
                resolver.getCharacterEncoding()));
        resolver.setExcludedViewNames(this.properties.getExcludedViewNames());
        resolver.setViewNames(this.properties.getViewNames());
        resolver.setOrder(Ordered.HIGHEST_PRECEDENCE + 111);
        return resolver;
    }

    private String appendCharset(String type, String charset) {
        if (type.contains("charset=")) {
            return type;
        }
        return type + ";charset=" + charset;
    }
}
