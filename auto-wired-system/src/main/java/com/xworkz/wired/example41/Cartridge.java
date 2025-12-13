package com.xworkz.wired.example41;

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
public class Cartridge {
    private String color;
    private int pages;
    private String type;
}
