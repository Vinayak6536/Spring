package com.xworkz.wired.example12;

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
public class Doctor {
    private String name;
    private String specialization;
    private int experience;
}
