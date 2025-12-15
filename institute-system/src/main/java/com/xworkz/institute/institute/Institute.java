package com.xworkz.institute.institute;

import com.xworkz.institute.trainee.Trainee;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Institute {
    private int id;
    private String name;

   @Qualifier("s2")
    Trainee trainee;
}
