package com.xworkz.demo.internet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class Internet {

    @Autowired
    public Internet(@Value("1") int id, @Value("jio") String name){
        this.id=id;
        this.name=name;
    }

    private int id;
    private String name;
}
