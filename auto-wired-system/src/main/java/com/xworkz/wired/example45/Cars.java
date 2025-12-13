package com.xworkz.wired.example45;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("cars")
@Scope("prototype")
public class Cars {
    private String brand;
    private String model;
    private double price;

    @Autowired
    GearBox gearBox;
}
