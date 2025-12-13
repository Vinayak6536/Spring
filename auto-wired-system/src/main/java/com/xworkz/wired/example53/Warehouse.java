package com.xworkz.wired.example53;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("warehouse")
@Scope("prototype")
public class Warehouse {
    private String name;
    private String city;
    private int workers;

    @Autowired
    StorageUnit storageUnit;
}
