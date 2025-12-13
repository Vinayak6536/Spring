package com.xworkz.wired.example3;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("car")
@Scope("prototype")
public class Car {
    private String brand;
    private int year;
    private double price;

    @Autowired
    Engine engine;
}
