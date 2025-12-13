package com.xworkz.wired.example46;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("television")
@Scope("prototype")
public class Television {
    private String brand;
    private int size;
    private boolean smartTv;

    @Autowired
    Remote remote;
}
