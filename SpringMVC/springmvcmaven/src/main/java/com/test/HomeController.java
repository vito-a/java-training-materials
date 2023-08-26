package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @EnableAutoConfiguration
public class HomeController {
    @RequestMapping("/home")
    String goHome() {
    	System.out.println("in home controller");
        return "index";
    }
}