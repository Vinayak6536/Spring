package com.xworkz.theatre.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@NamedQueries({
        @NamedQuery(name = "viewTheatres",query = "select e from TheatreEntity e"),
        @NamedQuery(name = "updateTheatre",query = "update TheatreEntity e set e.theatreName=:name," +
                "e.location=:loc,e.city=:city,e.totalScreens=:ts,e.ownerName=:owner,e.acAvailable=:available,e.ticketPrice=:price,e.contactNumber=:number where e.theatreId= :id")
})

public class TheatreEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
