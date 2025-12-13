package com.xworkz.wired.example8;

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
public class FuelTank {
    private int capacity;
    private String fuelType;
    private boolean reserve;
}
