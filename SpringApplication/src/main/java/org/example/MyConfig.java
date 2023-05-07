package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
    @Bean
    @Scope("prototype")
    public Human human () {
        return new Human();
    }

    @Bean
    @Scope("prototype")
    public Head head () {
        return new Head();
    }
}
