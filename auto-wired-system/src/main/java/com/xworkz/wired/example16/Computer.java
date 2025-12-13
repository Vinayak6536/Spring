package com.xworkz.wired.example16;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component("comp")
@Scope("prototype")
public class Computer {
    private String brand;
    private int ram;
    private double price;

    @Autowired
    Mouse mouse;
}
