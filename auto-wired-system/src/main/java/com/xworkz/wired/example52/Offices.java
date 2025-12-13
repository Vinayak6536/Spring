package com.xworkz.wired.example52;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("offices")
@Scope("prototype")
public class Offices {
    private String name;
    private String location;
    private int employees;

    @Autowired
    Cabin cabin;
}
