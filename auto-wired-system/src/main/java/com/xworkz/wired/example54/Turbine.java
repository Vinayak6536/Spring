package com.xworkz.wired.example54;

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
public class Turbine {
    private int capacity;
    private String type;
    private boolean running;
}
