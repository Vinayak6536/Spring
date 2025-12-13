package com.xworkz.wired.example44;

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
public class Strap {
    private String material;
    private String color;
    private int size;
}
