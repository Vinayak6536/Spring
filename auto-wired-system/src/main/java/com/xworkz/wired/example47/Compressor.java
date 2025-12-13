package com.xworkz.wired.example47;

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
public class Compressor {
    private String brand;
    private int capacity;
    private boolean inverter;
}
