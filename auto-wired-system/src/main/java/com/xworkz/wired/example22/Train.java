package com.xworkz.wired.example22;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("train")
@Scope("prototype")
public class Train {
    private String name;
    private String route;
    private int speed;

    @Autowired
    Coach coach;
}
