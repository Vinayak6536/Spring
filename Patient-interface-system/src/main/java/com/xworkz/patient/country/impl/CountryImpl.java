package com.xworkz.patient.country.impl;

import com.xworkz.patient.country.Country;
import com.xworkz.patient.state.State;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CountryImpl implements Country {

    @Autowired
    State state;


    @Override
    public void addCountry() {
        System.out.println("addCountry Method Invoked...");
        state.addState();
    }
}
