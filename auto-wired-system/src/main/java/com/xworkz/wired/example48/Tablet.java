package com.xworkz.wired.example48;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("tablet")
@Scope("prototype")
public class Tablet {
    private String brand;
    private String model;
    private double price;

    @Autowired
    Stylus stylus;
}
