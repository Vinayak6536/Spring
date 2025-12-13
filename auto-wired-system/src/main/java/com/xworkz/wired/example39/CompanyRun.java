package com.xworkz.wired.example39;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("companyrun")
public class CompanyRun {
    private String name;
    private String city;
    private int employees;

    @Autowired
    Project project;
}
