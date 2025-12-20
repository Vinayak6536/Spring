package com.xworkz.zomato.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.zomato")
public class ZomatoConfiguration {
    public ZomatoConfiguration(){
        System.out.println("Running ZomatoConfig.....");
    }
}
