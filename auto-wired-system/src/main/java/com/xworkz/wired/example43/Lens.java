package com.xworkz.wired.example43;

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
public class Lens {
    private String type;
    private int focalLength;
    private boolean zoom;

}
