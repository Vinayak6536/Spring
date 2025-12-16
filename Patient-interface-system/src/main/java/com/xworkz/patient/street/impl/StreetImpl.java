package com.xworkz.patient.street.impl;

import com.xworkz.patient.street.Street;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
public class StreetImpl implements Street {
    @Override
    public void addStreet() {
        System.out.println("AddStreet method invoked...");
    }


}
