package com;

import com.tutorialspoint.HelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "beanutza")
    public String sampleBean() { //sampleBean
        return "Spring super-project";
    }

    @Bean(name = "helloSpring")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}
