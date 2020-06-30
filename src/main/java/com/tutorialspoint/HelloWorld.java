package com.tutorialspoint;

import org.springframework.stereotype.Component;

@Component //--> numele beanului creat va fi helloWorld
public class HelloWorld {

    public void sayHello(){
        System.out.println("Hello wolrd from a spring bean");
    }


}
