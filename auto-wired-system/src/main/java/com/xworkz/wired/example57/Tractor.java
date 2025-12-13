package com.xworkz.wired.example57;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Scope("prototype")
public class Tractor {
    private String brand;
    private int horsepower;
    private boolean diesel;
}
