package com.xworkz.event.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "getEventByName",query = "select getname from EventEntity getname where getname.eventName= :ename" ),
        @NamedQuery(name = "deleteByEventName",query = "delete from EventEntity e where e.eventName= :eName")

})
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
