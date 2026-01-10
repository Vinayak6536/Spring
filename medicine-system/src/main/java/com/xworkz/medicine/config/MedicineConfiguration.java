package com.xworkz.medicine.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz.medicine")
public class MedicineConfiguration {
    public MedicineConfiguration(){
        System.out.println("Running Configuration....");
    }

    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setPrefix("/");
        return internalResourceViewResolver;
    }
}
