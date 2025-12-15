package com.xworkz.institute.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.institute")
public class InstituteConfiguration {
    public InstituteConfiguration(){
        System.out.println("Execute InstituteConfig....");
    }
}
