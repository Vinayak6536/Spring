package com.xworkz.wired.example44;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("watch")
@Scope("prototype")
public class Watch {
    private String brand;
    private String model;

    private double price;

    @Autowired
    Strap strap;
}
