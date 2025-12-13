package com.xworkz.wired.example7;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TvRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Tv tv = context.getBean(Tv.class);
        tv.setBrand("Sony");
        tv.setSize(55);
        tv.setPrice(60000);
        tv.setSpeaker(new Speaker(100, "Stereo", true));

        System.out.println(tv);

        System.out.println("main ended");
    }
}
