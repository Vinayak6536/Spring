package com.xworkz.wired.example15;

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
public class Seat {
    private String  material;
    private int number;
    private boolean recliner;
}
