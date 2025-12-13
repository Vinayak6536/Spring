package com.xworkz.wired.example37;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("bankmanager")
@Scope("prototype")
public class Bank {
    private String name;
    private String branch;
    private int employees;

    @Autowired
    Manager manager;
}
