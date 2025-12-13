package com.xworkz.wired.example19;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("restaurant")
@Scope("prototype")
public class Restaurant {
    private String name;
    private String location;
    private int tables;

    @Autowired
    Chef chef;
}
