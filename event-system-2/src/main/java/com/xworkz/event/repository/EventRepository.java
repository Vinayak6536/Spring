package com.xworkz.event.repository;

import com.xworkz.event.entity.EventEntity;

import java.util.Optional;

public interface EventRepository {
    boolean save(EventEntity eventEntity);

    Optional<EventEntity> getEvent(int id);

    boolean updateTimeById(int id,int time);

    boolean deleteById(int id);
}
