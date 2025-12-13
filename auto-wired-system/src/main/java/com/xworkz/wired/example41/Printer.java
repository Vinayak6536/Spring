package com.xworkz.wired.example41;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("printerscan")
@Scope("prototype")
public class Printer {
    private String brand;
    private String model;
    private boolean wireless;

    @Autowired
    Cartridge cartridge;
}
