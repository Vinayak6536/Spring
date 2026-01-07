package com.xworkz.event.repository;

import com.xworkz.event.entity.EventEntity;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    boolean save(EventEntity eventEntity);

    Optional<EventEntity> getEvent(int id);

    boolean updateTimeById(int id,int time);

    boolean deleteById(int id);

    EventEntity getEventByName(String eventName);

    List<EventEntity> getEventByTime(int time);

    Object[] getEventManagerAndLocationByName(String name);

    List<EventEntity> getAllEventlist();

    Object getLocationByTime(int time);

    String  getEventNameByManager(String manager);

    List<String> getAllManagerName();
}
