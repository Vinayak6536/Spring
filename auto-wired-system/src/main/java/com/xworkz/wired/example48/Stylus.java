package com.xworkz.wired.example48;

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
public class Stylus {
    private String brand;
    private boolean pressureSensitive;
    private int batteryLife;
}
