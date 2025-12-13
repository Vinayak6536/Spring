package com.xworkz.wired.example9;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("office")
@Scope("prototype")
public class Office {
    private String name;
    private int employees;
    private String location;

    @Autowired
    Printer printer;
}
