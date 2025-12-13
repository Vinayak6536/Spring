package com.xworkz.wired.example60;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("policeStation")
@Scope("prototype")
public class PoliceStation {
    private String name;
    private String city;
    private int staff;

    @Autowired
    Inspector inspector;
}
