package com.xworkz.wired.example5;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Scope(value = "prototype")
public class Pen {
    private String color;
    private String type;
    private double price;

}
