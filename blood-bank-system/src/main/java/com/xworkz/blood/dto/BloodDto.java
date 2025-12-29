package com.xworkz.blood.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BloodDto {
    private String donorId;
    private String firstName;
    private String lastName;
    private String dob;
    private int zipCode;
    private String email;
    private long phone;
    private String password;
    private String confirmPassword;
}
