package com.xworkz.wired.example20;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("hotel")
@Scope("prototype")
public class Hotel {
    private String name;
    private String location;
    private int stars;

    @Autowired
    HotelRoom hotelRoom;
}
