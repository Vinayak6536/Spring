package com.xworkz.theatre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TheatreDto {
    private int theatreId;
    private String theatreName;
    private String location;
    private String city;
    private int totalScreens;
    private int totalSeats;
    private String ownerName;
    private boolean acAvailable;
    private double ticketPrice;
    private String contactNumber;

}
