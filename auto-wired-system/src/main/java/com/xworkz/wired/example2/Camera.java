package com.xworkz.wired.example2;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Camera {
    private int megapixels;
    private String type;
    private boolean flash;
}
