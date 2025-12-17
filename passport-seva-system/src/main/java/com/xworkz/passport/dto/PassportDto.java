package com.xworkz.passport.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PassportDto {
    private String firstName;
    private String lastName;
    private int age;
    private Date dob;
    private long adharNo;
    private String address;
}
