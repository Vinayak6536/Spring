package com.xworkz.wired.example16;


import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Computer computer = context.getBean(Computer.class);
        computer.setBrand("HP");
        computer.setRam(8);
        computer.setPrice(45000);
        computer.setMouse(new Mouse(3, "Optical", 1600));

        System.out.println(computer);

        System.out.println("main ended");
    }
}
