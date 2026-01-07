package com.xworkz.event.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class EventEntity {
    @Id
 //   @Column(name = "id")
    private int id;

 //   @Column(name = "eventName")
    private String eventName;

  //  @Column(name = "location")
    private String location;

 //   @Column(name = "eventManager")
    private String eventManager;

   // @Column(name = "time")
    private int time;
}
