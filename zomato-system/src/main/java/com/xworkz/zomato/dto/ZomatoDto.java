package com.xworkz.zomato.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZomatoDto {
    private String name;
    private String ownerName;
    private int ownerAge;
    private long phoneNo;
    private String branch;
    private String address;
    private long pincode;
    private String city;
    private String state;
    private String country;

}
