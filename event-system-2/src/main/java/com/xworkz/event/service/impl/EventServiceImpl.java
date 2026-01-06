package com.xworkz.event.service.impl;

import com.xworkz.event.dto.EventDto;
import com.xworkz.event.entity.EventEntity;
import com.xworkz.event.repository.EventRepository;
import com.xworkz.event.repository.impl.EventRepositoryImpl;
import com.xworkz.event.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    EventRepository eventRepository=new EventRepositoryImpl();
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
}
