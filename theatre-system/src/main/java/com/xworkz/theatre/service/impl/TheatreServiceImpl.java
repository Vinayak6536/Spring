package com.xworkz.theatre.service.impl;

import com.xworkz.theatre.dto.TheatreDto;
import com.xworkz.theatre.entity.TheatreEntity;
import com.xworkz.theatre.repository.TheatreRepository;
import com.xworkz.theatre.service.TheatreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class TheatreServiceImpl implements TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private TheatreEntity entity;
    @Override
    public boolean validateAndSave(TheatreDto theatreDto) {
        if (theatreDto != null){
            BeanUtils.copyProperties(theatreDto,entity);
            boolean saved=theatreRepository.save(entity);
            return saved;
        }
        return false;
    }

    @Override
    public List<TheatreDto> viewTheatres() {
        List<TheatreEntity> theatreEntities=theatreRepository.viewTheatres();
       // System.out.println(theatreEntities);
        List<TheatreDto> theatreDto=new ArrayList<>();
        for (TheatreEntity entity1:theatreEntities ){
            TheatreDto theatreDto1=new TheatreDto();
            BeanUtils.copyProperties(entity1,theatreDto1);
            theatreDto.add(theatreDto1);
        }
        return theatreDto;
    }

    @Override
    public Optional<TheatreDto> editTheatre(int id) {
        System.out.println(id);
        if (id != 0){
         Optional<TheatreEntity> theatreEntity=   theatreRepository.editTheatre(id);
          //  System.out.println(theatreEntity);
         if (theatreEntity.isPresent()){
             TheatreDto theatreDto=new TheatreDto();
             BeanUtils.copyProperties(theatreEntity.get(),theatreDto);
            // System.out.println(theatreDto);
             return Optional.of(theatreDto);
         }
        }

        return Optional.empty();
    }

    @Override
    public boolean updateTheatre(TheatreDto theatreDto) {
        TheatreEntity entity1=new TheatreEntity();
        BeanUtils.copyProperties(theatreDto,entity1);
        return theatreRepository.updateTheatre(entity1);
    }

    @Override
    public boolean deleteTheatre(int id) {
        if (id != 0) {
            return theatreRepository.deleteTheatre(id);
        }
        return false;
    }
}
