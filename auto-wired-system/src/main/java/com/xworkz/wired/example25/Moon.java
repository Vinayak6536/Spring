package com.xworkz.wired.example25;

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
public class Moon {
    private String name;
    private double radius;
    private boolean hasWater;
}
