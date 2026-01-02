package com.xworkz.job.dao;

import com.xworkz.job.dto.EducationDto;
import com.xworkz.job.dto.ExperienceDto;
import com.xworkz.job.dto.PersonalDto;

import java.util.Optional;

public interface JobDao {
    boolean personalDataSave(PersonalDto personalDto);

    Optional<PersonalDto> getIdByName(String name);

    boolean educationDataSave(EducationDto educationDto);

    boolean experienceDataSave(ExperienceDto experienceDto);
}
