package com.xworkz.event.service;

import com.xworkz.event.dto.EventDto;

import java.util.Optional;

public interface EventService {
    boolean validateAndSave(EventDto eventDto);

   // Optional<EventDto> getEventInfo(EventDto eventDto);


    Optional<EventDto> getEventInfo(int id);

    boolean updateTimeById(int id,int time);

    boolean deleteById(int id);
}
