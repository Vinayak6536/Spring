package com.xworkz.wired.example42;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("bikes")
@Scope("prototype")
public class Bikes {
    private String brand;
    private String model;
    private double price;

    @Autowired
    BikeEngine engine;
}
