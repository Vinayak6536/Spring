package com.xworkz.passport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.passport")
public class PassportConfiguration {
public PassportConfiguration(){
    System.out.println("Running Passport Config....");
}
}
