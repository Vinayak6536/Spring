package com.xworkz.passport;

import com.xworkz.passport.config.PassportConfiguration;
import com.xworkz.passport.dto.PassportDto;
import com.xworkz.passport.service.PassportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PassportRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PassportConfiguration.class);

        PassportDto passportDto=new PassportDto();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Limit of insert values ");
        int size= sc.nextInt();
        for (int i=1;i<=size;i++){
            System.out.println("Enter First Name");
            passportDto.setFirstName(sc.next());

            System.out.println("Enter Last Name");
            passportDto.setLastName(sc.next());

            System.out.println("Enter Age");
            passportDto.setAge(sc.nextInt());

            System.out.println("Enter Date Of Birth");
            String dateInput=sc.next();

            SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");

            try {
                Date dob=new Date(sdf.parse(dateInput).getTime());
                passportDto.setDob(dob);
            } catch (ParseException e) {
                System.out.println("Enter Valid date format(dd-mm-yyyy)");;
            }


            System.out.println("Enter Adhar Number");
            passportDto.setAdharNo(sc.nextLong());

            System.out.println("Enter Address");
            passportDto.setAddress(sc.next());

            System.out.println("------------------------------------");
        }

        PassportService passportService=applicationContext.getBean(PassportService.class);
        passportService.validateAndSave(passportDto);


        System.out.println("main ended");
    }
}
