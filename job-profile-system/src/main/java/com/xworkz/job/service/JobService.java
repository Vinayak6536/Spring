package com.xworkz.job.service;

import com.xworkz.job.dto.EducationDto;
import com.xworkz.job.dto.PersonalDto;

import java.util.Optional;

public interface JobService {
    boolean validateAndSave(PersonalDto personalDto);

    Optional<PersonalDto> validateAndFetch(int id);

    boolean educationValidate(EducationDto educationDto);

    Optional<PersonalDto> getIdByPhone(long phone);
}
