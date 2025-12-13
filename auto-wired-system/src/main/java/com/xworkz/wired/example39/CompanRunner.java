package com.xworkz.wired.example39;

import com.xworkz.wired.config.WireConfiguration;
import com.xworkz.wired.example13.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        CompanyRun company = context.getBean(CompanyRun.class);

        company.setName("Wipro");
        company.setCity("Bangalore");
        company.setEmployees(250000);
        company.setProject(new Project("AI Platform", 18, 5.5));

        System.out.println(company);

        System.out.println("main ended");
    }
}
