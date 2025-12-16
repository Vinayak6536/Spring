package com.xworkz.patient.city.impl;

import com.xworkz.patient.area.Area;
import com.xworkz.patient.city.City;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CityImpl implements City {
    @Autowired
    Area area;

    @Override
    public void addCity() {
        System.out.println("addCity Method Invoked.....");
        area.addArea();
    }


}
