package com.xworkz.wired.example13;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("company")
@Scope("prototype")
public class Company {
    private String name;
    private String location;
    private int strength;

    @Autowired
    Employee employee;
}
