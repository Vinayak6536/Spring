package com.xworkz.wired.example26;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("city")
@Scope("prototype")
public class City {
    private String name;
    private int population;
    private double area;

    @Autowired
    Mayor mayor;
}
