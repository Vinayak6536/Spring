package com.xworkz.wired.example55;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("museum")
@Scope("prototype")
public class Museum {
    private String name;
    private String city;
    private int visitorsPerDay;

    @Autowired
    Artifact artifact;
}
