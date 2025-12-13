package com.xworkz.wired.example10;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("room")
@Scope("prototype")
public class Room {
    private String name;
    private int area;
    private int floor;

    @Autowired
    Fan fan;
}
