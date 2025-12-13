package com.xworkz.wired.example29;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("airportrun")
@Scope("prototype")
public class AirportRun {
    private String name;
    private String city;
    private int terminals;

    @Autowired
    Runway runway;
}
