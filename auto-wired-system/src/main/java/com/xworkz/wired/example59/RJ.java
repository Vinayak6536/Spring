package com.xworkz.wired.example59;


import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Scope("prototype")
public class RJ {
    private String name;
    private String show;
    private int experience;
}
