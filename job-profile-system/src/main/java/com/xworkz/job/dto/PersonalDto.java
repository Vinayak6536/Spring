package com.xworkz.job.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonalDto {
    private int id;
    private String firstName;
    private String lastName;
    private String dob;
    private int age;
    private String email;
    private long phone;

    public PersonalDto(int id, String name) {
         this.id=id;
         this.firstName=name;
    }

    public PersonalDto(int id) {
        this.id=id;
    }
}
