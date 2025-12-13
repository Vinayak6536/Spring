package com.xworkz.wired.example43;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CameraRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Camera camera = context.getBean(Camera.class);

        camera.setBrand("Nikon");
        camera.setModel("D7500");
        camera.setPrice(95000);
        camera.setLens(new Lens("Prime", 50, false));

        System.out.println(camera);

        System.out.println("main ended");
    }
}
