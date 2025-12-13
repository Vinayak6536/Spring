package com.xworkz.wired.example46;

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
public class Remote {
    private String type;
    private int buttons;
    private boolean smart;
}
