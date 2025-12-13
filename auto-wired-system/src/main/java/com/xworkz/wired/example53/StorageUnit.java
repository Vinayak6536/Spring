package com.xworkz.wired.example53;

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
public class StorageUnit {
    private int unitNo;
    private int capacity;
    private boolean refrigerated;
}
