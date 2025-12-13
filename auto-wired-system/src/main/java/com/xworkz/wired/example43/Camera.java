package com.xworkz.wired.example43;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("camara")
@Scope("prototype")
public class Camera {
    private String brand;
    private String model;
    private double price;

    @Autowired
    Lens lens;
}
