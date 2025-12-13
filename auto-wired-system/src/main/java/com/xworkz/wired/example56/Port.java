package com.xworkz.wired.example56;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("port")
@Scope("prototype")
public class Port {
    private String name;
    private String city;
    private int docks;

    @Autowired
    Shipment ship;
}
