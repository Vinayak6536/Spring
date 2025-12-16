package com.xworkz.patient.address.impl;

import com.xworkz.patient.address.Address;
import com.xworkz.patient.country.Country;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AddressImpl implements Address {

    @Autowired
    Country country;

    @Override
    public void addAddress() {
        System.out.println("Add address method Invoked...a");
        country.addCountry();

    }
}
