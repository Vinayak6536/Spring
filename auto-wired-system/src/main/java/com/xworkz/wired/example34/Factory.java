package com.xworkz.wired.example34;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("factory")
@Scope("prototype")
public class Factory {
    private String name;
    private String location;
    private int workers;

    @Autowired
    Machine machine;
}
