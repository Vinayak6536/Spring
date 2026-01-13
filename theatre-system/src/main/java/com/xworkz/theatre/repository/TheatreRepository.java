package com.xworkz.theatre.repository;

import com.xworkz.theatre.dto.TheatreDto;
import com.xworkz.theatre.entity.TheatreEntity;

import java.util.List;
import java.util.Optional;

public interface TheatreRepository {
    boolean save(TheatreEntity theatreEntity);

    List<TheatreEntity> viewTheatres();

    Optional<TheatreEntity> editTheatre(int id);

    boolean updateTheatre(TheatreEntity theatreEntity);

    boolean deleteTheatre(int id);
}
