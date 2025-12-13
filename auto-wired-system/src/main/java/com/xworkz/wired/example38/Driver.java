package com.xworkz.wired.example38;

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
public class Driver {
    private String name;
    private int licenseNo;
    private int experience;
}
