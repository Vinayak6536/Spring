package com.xworkz.wired.example58;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("court")
@Scope("prototype")
public class Court {
    private String name;
    private String city;
    private int casesPerDay;

    @Autowired
    Judge judge;
}
