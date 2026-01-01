package com.xworkz.spring.airport;

import com.xworkz.spring.terminal.Terminal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component("airport")
@Scope("prototype")                         //this scope using to create multiple address/objects or diffrent addresses
public class Airport {
    @Autowired  //
    Terminal terminal;

    private int airportId;

    public Airport(){
        System.out.println("Airport invoked");
    }
}
