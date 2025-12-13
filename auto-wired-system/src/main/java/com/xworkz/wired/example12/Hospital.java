package com.xworkz.wired.example12;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("hospital")
@Scope("prototype")
public class Hospital {
    private String name;
    private String city;
    private int beds;

    @Autowired
    Doctor doctor;
}
