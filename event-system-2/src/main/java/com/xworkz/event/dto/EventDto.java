package com.xworkz.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private int id;
    private String eventName;
    private String location;
    private String eventManager;
    private int time;
}
