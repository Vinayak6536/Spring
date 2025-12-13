package com.xworkz.wired.example19;

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
public class Chef {
    private String name;
    private String cuisine;
    private int experience;
}
