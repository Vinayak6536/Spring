package com.xworkz.patient.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.xworkz.patient")
public class PatientConfiguration {
    public PatientConfiguration(){
        System.out.println("Running Patient Config.....");
    }
}
