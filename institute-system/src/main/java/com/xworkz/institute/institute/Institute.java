package com.xworkz.institute.institute;

import com.xworkz.institute.trainee.Trainee;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
@AllArgsConstructor

@ToString
@Component
public class Institute {

    public Institute(){
        System.out.println("Created Institute Constructor");
    }

    @PostConstruct
    public void initInstitute(){
        System.out.println("Init Institute ref");
    }


    @PreDestroy
    public void destroyInstitute(){
        System.out.println("Close all costly resources");
    }



    private int id;
    private String name;

   @Qualifier("s2")
    Trainee trainee;
}
