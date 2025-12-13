package com.xworkz.wired.example17;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Scope("prototype")
public class Projector {
    private String brand;
    private int lumens;
    private boolean hd;
}
