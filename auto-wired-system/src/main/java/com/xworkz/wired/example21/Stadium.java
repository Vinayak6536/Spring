package com.xworkz.wired.example21;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("stadium")
@Scope("prototype")
public class Stadium {
    private String name;
    private int capacity;
    private String city;

    @Autowired
    Seats seats;
}
