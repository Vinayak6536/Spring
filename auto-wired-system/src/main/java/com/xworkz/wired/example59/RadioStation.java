package com.xworkz.wired.example59;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("radioStation")
@Scope("prototype")
public class RadioStation {
    private String name;
    private double frequency;
    private String city;

    @Autowired
    RJ rj;
}
