package com.xworkz.wired.example11;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("school")
@Scope("prototype")
public class School {
    private String name;
    private String city;
    private int students;

    @Autowired
    Teacher teacher;
}
