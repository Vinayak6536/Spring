package com.xworkz.wired.example37;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Bank bank = context.getBean(Bank.class);

        bank.setName("HDFC");
        bank.setBranch("BTM Layout");
        bank.setEmployees(45);
        bank.setManager(new Manager("Raghav", 15, "A"));

        System.out.println(bank);

        System.out.println("main ended");
    }
}
