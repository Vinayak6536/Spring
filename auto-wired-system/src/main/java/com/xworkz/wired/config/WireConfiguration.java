package com.xworkz.wired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.wired")
public class WireConfiguration {
    public WireConfiguration(){
        System.out.println("Running Config class....");
    }
}
