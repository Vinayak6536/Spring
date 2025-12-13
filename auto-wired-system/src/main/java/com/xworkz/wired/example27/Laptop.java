package com.xworkz.wired.example27;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("laptop")
@Scope("prototype")
public class Laptop {
    private String brand;
    private String model;
    private double price;

    @Autowired
    RAM ram;
}
