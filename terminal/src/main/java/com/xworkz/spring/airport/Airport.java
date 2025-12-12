package com.xworkz.spring.airport;

import com.xworkz.spring.terminal.Terminal;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component("airport")
public class Airport {
    @Autowired
    Terminal terminal;

    private int airportId;

    public Airport(){
        System.out.println("Airport invoked");
    }
}
