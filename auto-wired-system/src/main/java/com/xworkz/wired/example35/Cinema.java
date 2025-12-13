package com.xworkz.wired.example35;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("cinema")
@Scope("prototype")
public class Cinema {
    private String name;
    private String city;
    private int shows;

    @Autowired
    Screen screen;
}
