package com.xworkz.wired.example20;

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
public class HotelRoom {
    private int number;
    private String type;
    private double price;
}
