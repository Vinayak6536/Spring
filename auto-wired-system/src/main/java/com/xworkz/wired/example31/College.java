package com.xworkz.wired.example31;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("college")
@Scope("prototype")
public class College {
    private String name;
    private String city;
    private int students;

    @Autowired
    Principal principal;
}
