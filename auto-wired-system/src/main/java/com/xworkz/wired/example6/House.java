package com.xworkz.wired.example6;

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
@Component("house")
@Scope("prototype")
public class House {
    private String owner;
    private int rooms;
    private String city;

    @Autowired
    Door door;
}
