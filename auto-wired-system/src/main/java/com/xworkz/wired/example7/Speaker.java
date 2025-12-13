package com.xworkz.wired.example7;

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
public class Speaker {
    private int watt;
    private String type;
    private boolean bluetooth;

}
