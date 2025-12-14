package com.xworkz.wired.example33;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("university")
@Scope("prototype")
public class University {
    private String name;
    private String city;
    private int colleges;

    @Autowired
    public Professor professor;
}
