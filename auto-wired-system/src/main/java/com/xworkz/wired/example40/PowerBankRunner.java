package com.xworkz.wired.example40;

import com.xworkz.wired.config.WireConfiguration;
import com.xworkz.wired.example2.Mobile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PowerBankRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        PowerBank powerBank = context.getBean(PowerBank.class);

        powerBank.setBrand("Samsung");
        powerBank.setModel("S23");
        powerBank.setPrice(85000);
        powerBank.setCharger(new Charger(45, "USB-C", true));

        System.out.println(powerBank);

        System.out.println("main ended");
    }
}
