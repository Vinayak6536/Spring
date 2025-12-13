package com.xworkz.wired.example51;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("theatre")
@Scope("prototype")
public class Theatre {
    private String name;
    private String city;
    private int shows;

    @Autowired
    Screen1 screen;
}
