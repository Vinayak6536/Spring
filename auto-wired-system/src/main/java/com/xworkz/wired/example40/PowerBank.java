package com.xworkz.wired.example40;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("powerbank")
@Scope("prototype")
public class PowerBank {
    private String brand;
    private String model;
    private double price;

    @Autowired
    Charger charger;
}
