package com.xworkz.theatre.service;

import com.xworkz.theatre.dto.TheatreDto;

import java.util.List;
import java.util.Optional;

public interface TheatreService {
    boolean validateAndSave(TheatreDto theatreDto);

    List<TheatreDto> viewTheatres();

    Optional<TheatreDto> editTheatre(int id);

    boolean updateTheatre(TheatreDto theatreDto);

    boolean deleteTheatre(int id);
}
