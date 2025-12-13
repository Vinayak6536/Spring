package com.xworkz.wired.example13;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyRunner {
    public static void main(String[] args) {
        System.out.println("main started");


        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Company company = context.getBean(Company.class);
        company.setName("Tech Solutions");
        company.setLocation("Hyderabad");
        company.setStrength(500);
        company.setEmployee(new Employee(101, "Alice", 60000));

        System.out.println(company);


        System.out.println("main ended");
    }
}
