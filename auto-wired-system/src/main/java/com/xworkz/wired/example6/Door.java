package com.xworkz.wired.example6;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Component
@Scope("prototype")
public class Door {
    private String material;
    private int height;
    private boolean lock;

}
