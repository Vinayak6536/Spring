package com.xworkz.wired.example4;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("book")
@Scope("prototype")
public class Book {
    private String title;
    private int pages;
    private double price;

    @Autowired
    Author author;
}
