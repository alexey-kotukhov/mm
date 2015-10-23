package com.example;

import com.example.m1.M1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


@Configuration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = 
        {
            @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
            @ComponentScan.Filter(value = M1Config.class, type = FilterType.ASSIGNABLE_TYPE),    
            @ComponentScan.Filter(value = RootConfig.class, type = FilterType.ASSIGNABLE_TYPE),    
        }
)
public class MmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmApplication.class, args);
    }
}
