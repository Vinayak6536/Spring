package com.xworkz.wired.example23;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("movie")
@Scope("prototype")
public class Movie {

    private String title;
    private String genre;
    private double budget;

    @Autowired
    Actor actor;
}

