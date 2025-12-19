package com.xworkz.medicine.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.medicine")
public class MedicineConfiguration {
    public MedicineConfiguration(){
        System.out.println("Running MedicineConfig....");
    }
}
