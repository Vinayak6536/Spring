package com.xworkz.wired.example24;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("ship")
@Scope("prototype")
public class Ship {
    private String name;
    private double tonnage;
    private String type;

    @Autowired
    Captain captain;
}
