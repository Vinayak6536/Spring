package com.xworkz.wired.example16;

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
public class Mouse {
    private int buttons;
    private String type;
    private int dpi;
}
