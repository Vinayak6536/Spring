package com.xworkz.patient.state.impl;

import com.xworkz.patient.city.City;
import com.xworkz.patient.state.State;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StateImpl implements State {
    @Autowired
    City city;

    @Override
    public void addState() {
        System.out.println("addState method invoked...");
        city.addCity();
    }
}
