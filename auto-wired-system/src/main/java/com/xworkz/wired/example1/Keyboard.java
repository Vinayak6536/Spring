package com.xworkz.wired.example1;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
@AllArgsConstructor
@Scope("prototype")
public class Keyboard {

    private int keys;
    private String type;
    private String layout;

}
