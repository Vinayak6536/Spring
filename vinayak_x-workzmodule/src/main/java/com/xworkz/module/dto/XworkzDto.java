package com.xworkz.module.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XworkzDto {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private long phoneNo;
    private String email;
    private String password;
    private String ConfirmPassword;
}
