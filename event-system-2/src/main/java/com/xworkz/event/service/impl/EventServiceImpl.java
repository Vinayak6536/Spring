package com.xworkz.event.service.impl;

import com.xworkz.event.dto.EventDto;
import com.xworkz.event.entity.EventEntity;
import com.xworkz.event.repository.EventRepository;
import com.xworkz.event.repository.impl.EventRepositoryImpl;
import com.xworkz.event.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    EventRepository eventRepository=new EventRepositoryImpl();
    EventDto dto=new EventDto();
    @Override
    public boolean validateAndSave(EventDto eventDto) {
        if (eventDto != null){
            EventEntity eventEntity=new EventEntity();
            BeanUtils.copyProperties(eventDto,eventEntity);

            return eventRepository.save(eventEntity);
        }
        return false;
    }

    @Override
    public Optional<EventDto> getEventInfo(int id) {

        Optional<EventEntity> event=eventRepository.getEvent(id);

        if (event.isPresent()){
            EventDto eventDto=new EventDto();
            BeanUtils.copyProperties(event.get(),eventDto);
            return Optional.of(eventDto);
        }

        return Optional.empty();
    }

    @Override
    public boolean updateTimeById(int id, int time) {
        eventRepository.updateTimeById(id,time);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        eventRepository.deleteById(id );
        return true;
    }

    @Override
    public EventDto getEventByName(String eventName) {
        if (eventName != null){


            EventEntity entity=eventRepository.getEventByName(eventName);
            BeanUtils.copyProperties(entity,dto);
            return dto;
        }
        return null;
    }

    @Override
    public List<EventEntity> getEventByTime(int time) {
        if (time != 0){
            List<EventEntity> entity=eventRepository.getEventByTime(time);
            return entity;
        }
        return null;
    }

    @Override
    public Object[] getEventManagerAndLocationByName(String name) {
        if (name != null){
            Object[] getName=eventRepository.getEventManagerAndLocationByName(name);
            return getName;
        }
        return null;
    }

    @Override
    public List<EventEntity> getAllEventlist() {
        List<EventEntity> list=eventRepository.getAllEventlist();
        if (list != null) {

            return list;
        }

        return Collections.emptyList();
    }

    @Override
    public Object getLocationByTime(int time) {
        if (time != 0){
          return eventRepository.getLocationByTime(time);
        }
        return null;
    }

    @Override
    public String getEventNameByManager(String manager) {
        return eventRepository.getEventNameByManager(manager);
    }

    @Override
    public List<String> getAllManagerName() {
        return eventRepository.getAllManagerName();
    }
}
