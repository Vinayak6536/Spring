package com.xworkz.event.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

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
