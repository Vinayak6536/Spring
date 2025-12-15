package com.xworkz.institute.trainee.impl;

import com.xworkz.institute.trainee.Trainee;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import org.springframework.stereotype.Component;
@Setter
@Getter
@ToString
@Component
public class TraineeImpl implements Trainee {
    @Override
    public void addTrainee( int id, String name) {
        System.out.println(("Invoked Add Trainee mathod..."));

        System.out.println(id+" "+name);

        System.out.println("end add Trainee method....");
    }
}
