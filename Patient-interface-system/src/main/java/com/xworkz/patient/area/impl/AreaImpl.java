package com.xworkz.patient.area.impl;

import com.xworkz.patient.area.Area;
import com.xworkz.patient.street.Street;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AreaImpl implements Area {
    @Autowired
    Street street;

    @Override
    public void addArea() {
        System.out.println("AddArea method invoked...");
        street.addStreet();
    }

}
