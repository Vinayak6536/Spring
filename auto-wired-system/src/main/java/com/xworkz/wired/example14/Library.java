package com.xworkz.wired.example14;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("library")
@Scope("prototype")
public class Library {
    private String name;
    private String city;
    private int books;

    @Autowired
    BookShelf bookShelf;
}
