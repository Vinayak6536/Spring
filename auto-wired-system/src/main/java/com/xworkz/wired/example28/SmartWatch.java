package com.xworkz.wired.example28;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("smartwatch")
@Scope("prototype")
public class SmartWatch {
    private String brand;
    private String model;
    private double price;

    @Autowired
    Sensor sensor;
}
