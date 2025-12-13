package com.xworkz.wired.example18;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Bank bank = context.getBean(Bank.class);
        bank.setName("State Bank");
        bank.setBranch("MG Road");
        bank.setIfsc("SBIN00123");
        bank.setAccount(new Account(1234567890L, "Saving", 50000));

        System.out.println(bank);

        System.out.println("main ended");
    }
}
