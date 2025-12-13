package com.xworkz.wired.example49;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("refrigerator")
@Scope("prototype")
public class Refrigerator {
    private String brand;
    private int litres;
    private double price;

    @Autowired
    Freezer freezer;
}
