package com.xworkz.wired.example60;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Component("policeStationOne")
@Scope("prototype")
public class PoliceStationOne {
    private String name;
    private String city;
    private int staff;

    @Autowired
    Inspector inspector;
}
