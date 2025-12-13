package com.xworkz.wired.example1;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Main started");

        ApplicationContext applicationContext=new  AnnotationConfigApplicationContext(WireConfiguration.class);

        ComputerSystem computerSystem=applicationContext.getBean(ComputerSystem.class);

        computerSystem.setBrand("Asus");
        computerSystem.setRam(16);
        computerSystem.setPrice(57000);
        computerSystem.setKeyboard(new Keyboard(32,"board","square"));

        System.out.println(computerSystem);

        System.out.println("main ended");
    }
}
