package com.xworkz.zomato.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "zomato")
public class ZomatoDto {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "ownername")
    private String ownerName;

    @Column(name = "ownerage")
    private int ownerAge;

    @Column(name = "phoneno")
    private long phoneNo;

    @Column(name = "branch")
    private String branch;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private long pincode;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

}
