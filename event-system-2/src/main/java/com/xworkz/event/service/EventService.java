package com.xworkz.event.service;

import com.xworkz.event.dto.EventDto;
import com.xworkz.event.entity.EventEntity;

import java.util.List;
import java.util.Optional;

public interface EventService {
    boolean validateAndSave(EventDto eventDto);

   // Optional<EventDto> getEventInfo(EventDto eventDto);


    Optional<EventDto> getEventInfo(int id);

    boolean updateTimeById(int id,int time);

    boolean deleteById(int id);

    EventDto getEventByName(String eventName);

    List<EventEntity> getEventByTime(int time);

    Object[] getEventManagerAndLocationByName(String name);

    List<EventEntity> getAllEventlist();

    Object getLocationByTime(int time);

    String  getEventNameByManager(String manager);

    List<String> getAllManagerName();

    boolean updateEventManagerByEventNameAndEventTime(String eventManager,String eventName,int time);

    boolean updateEventTimeByEventName(String eventName,int time);

    boolean deleteByEventName(String eventName);
}
