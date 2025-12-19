package com.xworkz.personalloan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.personalloan")
public class PersonalLoanConfiguration {
    public PersonalLoanConfiguration(){
        System.out.println("Running PersonalLoanConfig....");
    }
}
