package com.xworkz.wired.example36;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("railwaystation")
@Scope("prototype")
public class RailwayStation {
    private String name;
    private String city;
    private int trains;

    @Autowired
    Platform platform;
}
