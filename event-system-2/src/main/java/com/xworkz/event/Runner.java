package com.xworkz.event;

import com.xworkz.event.dto.EventDto;
import com.xworkz.event.entity.EventEntity;
import com.xworkz.event.service.EventService;
import com.xworkz.event.service.impl.EventServiceImpl;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class Runner {
    public static void main(String[] args) {
        EventService eventService=new EventServiceImpl();
        EventDto dto=new EventDto(1,"Photo","Bangalore","Modak",9);
        EventDto dto1=new EventDto(2,"magic-show","sirasi","Chaitanya",10);

       // eventService.validateAndSave(dto1);

        Optional<EventDto> eventDto=eventService.getEventInfo(1);
        System.out.println(eventDto.get());

        boolean update=eventService.updateTimeById(1,11);
        System.out.println(update);

        boolean delete=eventService.deleteById(1);
        System.out.println(delete);
    }
}
