package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
// @EnableAutoConfiguration
public class HomeController {
    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value="/")
    public String Welcome() {
        StringBuilder beanNames = new StringBuilder();
        String[] beanNamesString = appContext.getBeanDefinitionNames();
        Arrays.sort(beanNamesString);
        for (String beanName : beanNamesString) {
            beanName = beanName + "\n<br />";
            System.out.println(beanName);
            beanNames.append(beanName);
        }
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        return "Welcome to Spring Boot \n<br /><br />" +
               "Subscribe and leave a comment<br /><br />" +
                beanNames;
    }

    @RequestMapping("/hello")
    String home() {
        return "Hello!";
    }

    @GetMapping("/home")
    public String viewHomePage() {
        return "index.html";
    }
}