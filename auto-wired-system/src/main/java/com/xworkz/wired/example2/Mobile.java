package com.xworkz.wired.example2;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component("mobile")
@Scope("prototype")
public class Mobile {
    private String brand;
    private String model;
    private double price;

    @Autowired
    Camera camera;
}
