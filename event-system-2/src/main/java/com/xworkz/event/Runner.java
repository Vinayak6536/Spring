package com.xworkz.event;

import com.xworkz.event.dto.EventDto;
import com.xworkz.event.entity.EventEntity;
import com.xworkz.event.service.EventService;
import com.xworkz.event.service.impl.EventServiceImpl;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        EventService eventService=new EventServiceImpl();
        EventDto dto=new EventDto(1,"Photo","Bangalore","Modak",9);
        EventDto dto1=new EventDto(2,"magic-show","sirasi","Chaitanya",10);

       // eventService.validateAndSave(dto1);

      //  Optional<EventDto> eventDto=eventService.getEventInfo(1);
       // System.out.println(eventDto.get());

        boolean update=eventService.updateTimeById(1,11);
        System.out.println(update);

        boolean delete=eventService.deleteById(1);
        System.out.println(delete);

        EventDto eventDto1=eventService.getEventByName("magic-show");
        System.out.println(eventDto1);

        List<EventEntity> eventDto=eventService.getEventByTime(10);
        Stream.of(eventDto).forEach(System.out::println);

        Object[] getName=eventService.getEventManagerAndLocationByName("magic-show");
        Stream.of(getName).forEach(System.out::println);

        Stream.of(eventService.getAllEventlist()).forEach(System.out::println);

        Object dev=eventService.getLocationByTime(10);
        System.out.println(dev);

        System.out.println(eventService.getEventNameByManager("Chaitanya"));

        Stream.of(eventService.getAllManagerName()).forEach(System.out::println);
    }
}
