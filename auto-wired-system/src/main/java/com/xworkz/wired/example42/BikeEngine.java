package com.xworkz.wired.example42;

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
public class BikeEngine {
    private int cc;
    private String type;
    private boolean fuelInjected;
}
