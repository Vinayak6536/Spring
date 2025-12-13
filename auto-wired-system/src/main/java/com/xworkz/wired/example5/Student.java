package com.xworkz.wired.example5;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("student")
@Scope("prototype")
public class Student {
    private String name;
    private int rollNo;
    private String grade;

    @Autowired
    Pen pen;
}
