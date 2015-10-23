/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.m1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author leha
 */
@Controller
public class M1TestController {
    
    private static final Logger logger = LoggerFactory.getLogger(M1TestController.class);
    
    @RequestMapping("/mmm")
    public String test() {
        
        logger.debug("mmmm aaaa");
        
        return "mmm";
    }
}
