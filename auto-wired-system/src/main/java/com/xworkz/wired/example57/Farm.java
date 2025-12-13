package com.xworkz.wired.example57;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("farm")
@Scope("prototype")
public class Farm {
    private String owner;
    private String location;
    private int acres;

    @Autowired
    Tractor tractor;
}
