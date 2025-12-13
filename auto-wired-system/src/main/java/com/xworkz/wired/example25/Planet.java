package com.xworkz.wired.example25;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("planet")
@Scope("prototype")
public class Planet {
    private String name;
    private double mass;
    private int noOfMoons;
@Autowired
     Moon moon;
}
