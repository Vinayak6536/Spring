package com.xworkz.wired.example15;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("bus")
@Scope("prototype")
public class Bus {
    private String route;
    private int capacity;
    private double fare;

    @Autowired
    Seat seat;
}
