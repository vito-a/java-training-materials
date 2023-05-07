package org.example;

import org.example.controller.AppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@Configuration
//@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackageClasses = HomeController.class)
@ComponentScan(basePackageClasses = AppController.class)
public class MySpringBoot {
    @Bean
    Human service () {
        return new Human();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MySpringBoot.class, args);
    }

    /*
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
    */
}
