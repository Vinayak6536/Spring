package com.xworkz.wired.example60;

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
public class Inspector {
    private String name;
    private int badgeNo;
    private int experience;
}
