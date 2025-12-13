package com.xworkz.wired.example47;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("airConditioner")
@Scope("prototype")
public class AirConditioner {
    private String brand;
    private int ton;
    private double price;

    @Autowired
    Compressor compressor;
}
