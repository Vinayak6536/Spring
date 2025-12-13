package com.xworkz.wired.example30;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("zoo")
@Scope("prototype")
public class Zoo {
    private String name;
    private String city;
    private int animals;

    @Autowired
    Keeper keeper;
}
