package com.xworkz.wired.example10;

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
public class Fan {
    private int speed;
    private String type;
    private boolean remote;
}
