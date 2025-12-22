package com.xworkz.zomato.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
