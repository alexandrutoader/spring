package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service("dependencyBean")
@Getter
@AllArgsConstructor
public class BeanWIthDependencyOfHelloWorld {

    @Qualifier("helloSpring")
//    @Autowired --> field injection
    private final HelloWorld helloWorld;
}
