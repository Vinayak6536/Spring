package com.xworkz.module.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Component

public class XworkzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private long phoneNo;
    private String email;
    private String password;
    private int count;

    private int otp;
    private LocalDateTime otpCreatedTime;
}
