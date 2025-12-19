package com.xworkz.personalloan;

import com.xworkz.personalloan.config.PersonalLoanConfiguration;
import com.xworkz.personalloan.dto.PersonalLoanDto;
import com.xworkz.personalloan.service.PersonalLoanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class PersonalloanRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PersonalLoanConfiguration.class);
        PersonalLoanDto personalLoanDto=new PersonalLoanDto();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Limit of insert values ");
        int size= sc.nextInt();
        for (int i=1;i<=size;i++) {
            System.out.println("Enter Name");
            personalLoanDto.setName(sc.next());

            System.out.println("Enter SurName");
            personalLoanDto.setSurName(sc.next());

            System.out.println("Enter Gender in only 'M' or 'F'");
            personalLoanDto.setGender(sc.next().charAt(0));

            System.out.println("Enter Date Of Birth 'dd-mm-yyyy'");
            personalLoanDto.setDob(sc.next());

            System.out.println("Enter Adhar Number");
            personalLoanDto.setAdharNO(sc.nextLong());

            System.out.println("Enter Phone number");
            personalLoanDto.setPhoneNo(sc.nextLong());

            System.out.println("Enter Email");
            personalLoanDto.setEmail(sc.next());

            System.out.println("Enter Marital Status");
            personalLoanDto.setMaritalStatus(sc.next());

            System.out.println("Enter Address");
            personalLoanDto.setAddress(sc.next());

            System.out.println("---------------");

        }

        PersonalLoanService personalLoanService=applicationContext.getBean(PersonalLoanService.class);
        personalLoanService.validateAndSave(personalLoanDto);
        System.out.println("main ended");
    }
}
