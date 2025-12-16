package com.xworkz.patient;

import com.xworkz.patient.config.PatientConfiguration;
import com.xworkz.patient.patient.PatientDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PatientConfiguration.class);
        PatientDetails patientDetails=applicationContext.getBean(PatientDetails.class);
        patientDetails.getPatientAddress();
        patientDetails.setId(1);
        patientDetails.setName("Darshan");

        System.out.println(patientDetails);
        System.out.println("main ended");
    }
}
