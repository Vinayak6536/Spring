package com.xworkz.wired.example22;

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
public class Coach {
    private String type;
    private int seats;
    private boolean ac;
}
