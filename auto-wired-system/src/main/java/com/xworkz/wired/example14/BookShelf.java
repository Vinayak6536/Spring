package com.xworkz.wired.example14;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Scope("prototype")
public class BookShelf {
    private int shelves;
    private String material;
    private boolean locked;
}
