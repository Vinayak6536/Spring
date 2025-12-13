package com.xworkz.wired.example7;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Component("tv")
@Scope("prototype")
public class Tv {
    private String brand;
    private int size;
    private double price;

    @Autowired
    Speaker speaker;
}
