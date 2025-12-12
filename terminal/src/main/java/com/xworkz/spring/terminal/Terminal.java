package com.xworkz.spring.terminal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Component
public class Terminal {
    private int id;
    private String terminalName;

    public Terminal(){
        System.out.println("Terminal Invoked");
    }
}
