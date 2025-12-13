package com.xworkz.wired.example38;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("busdriver")
@Scope("prototype")
public class BusDriver {
    private String number;
    private String route;
    private int seats;

    @Autowired
    Driver driver;
}
