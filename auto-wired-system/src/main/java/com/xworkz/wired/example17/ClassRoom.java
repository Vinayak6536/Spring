package com.xworkz.wired.example17;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("classroom")
@Scope("prototype")
public class ClassRoom {
    private String name;
    private int capacity;
    private int floor;

    @Autowired
    Projector projector;
}
