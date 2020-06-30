package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {// implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        String beanutza = (String) applicationContext.getBean("beanutza");
//        System.out.println("beanutza-->" + beanutza);
//
//		BeanWIthDependencyOfHelloWorld bean = applicationContext.getBean(BeanWIthDependencyOfHelloWorld.class);
//		bean.getHelloWorld().sayHello();
//    }
}
