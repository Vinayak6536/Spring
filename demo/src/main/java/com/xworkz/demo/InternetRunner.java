package com.xworkz.demo;

import com.xworkz.demo.configuration.DemoConfiguration;
import com.xworkz.demo.internet.Internet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InternetRunner {
    public static void main(String[] args) {
        System.out.println("main started");
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(DemoConfiguration.class);

        Internet internet=applicationContext.getBean(Internet.class);
      internet.setId(2);
      internet.setName("Airtel");
        System.out.println(internet);

//        Internet internet1=applicationContext.getBean(Internet.class);
//
//        internet1.setId(2);
//        internet1.setName("manoj");
//
//        System.out.println(internet1);

        System.out.println("main ended");
        }
    }

