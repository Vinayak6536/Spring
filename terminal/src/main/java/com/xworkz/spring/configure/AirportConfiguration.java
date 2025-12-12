package com.xworkz.spring.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.spring")
public class AirportConfiguration {
    public AirportConfiguration(){
        System.out.println("Airport Config invoked...");
    }
}
