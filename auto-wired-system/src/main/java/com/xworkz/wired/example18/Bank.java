package com.xworkz.wired.example18;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("bank")
@Scope("prototype")
public class Bank {
    private String name;
    private String branch;
    private String ifsc;

    @Autowired
    Account account;
}
