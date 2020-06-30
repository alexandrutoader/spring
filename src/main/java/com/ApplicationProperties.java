package com;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties("com.siit")
@Data
public class ApplicationProperties {

    private int numberOfStudents;
}
