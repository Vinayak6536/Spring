package com.xworkz.wired.example32;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("mall")
@Scope("prototype")
public class Mall {
    private String name;
    private String city;
    private int shops;

    @Autowired
    Shop shop;
}
