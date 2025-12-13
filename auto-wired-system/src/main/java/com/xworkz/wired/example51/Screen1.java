package com.xworkz.wired.example51;

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
public class Screen1 {
    private int number;
    private String type;
    private int capacity;


}
