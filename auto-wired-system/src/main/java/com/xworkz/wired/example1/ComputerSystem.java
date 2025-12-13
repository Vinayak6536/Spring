package com.xworkz.wired.example1;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component("computer")

@Scope("prototype")
public class ComputerSystem {
    private String brand;
    private int ram;
    private double price;
    @Autowired
    Keyboard keyboard;
}
