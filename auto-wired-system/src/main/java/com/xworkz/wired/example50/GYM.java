package com.xworkz.wired.example50;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("gym")
@Scope("prototype")
public class GYM {
    private String name;
    private String area;
    private int equipments;

    @Autowired
    Trainer trainer;
}
