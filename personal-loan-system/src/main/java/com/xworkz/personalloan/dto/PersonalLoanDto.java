package com.xworkz.personalloan.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonalLoanDto {
    private String name;
    private String surName;
    private char gender;
    private String dob;
    private long adharNO;
    private long phoneNo;
    private String email;
    private String maritalStatus;
    private String address;

}
