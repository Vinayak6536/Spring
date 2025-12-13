package com.xworkz.wired.example12;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HospitalRunner {
    public static void main(String[] args) {
        System.out.println("main started");


        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Hospital hospital = context.getBean(Hospital.class);
        hospital.setName("City Hospital");
        hospital.setCity("Pune");
        hospital.setBeds(200);
        hospital.setDoctor(new Doctor("Dr. Smith", "Cardiology", 15));

        System.out.println(hospital);

        System.out.println("main ended");
    }
}
