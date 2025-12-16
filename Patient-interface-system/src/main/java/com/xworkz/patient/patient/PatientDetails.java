package com.xworkz.patient.patient;

import com.xworkz.patient.address.Address;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class PatientDetails {
    private int id;
    private String name;

    @Autowired
    Address address;

    public void getPatientAddress(){

        address.addAddress();
    }
}
