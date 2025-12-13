package com.xworkz.wired.example54;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("powerplant")
@Scope("prototype")
public class PowerPlant {
    private String name;
    private String location;
    private int units;

    @Autowired
    Turbine turbine;
}
