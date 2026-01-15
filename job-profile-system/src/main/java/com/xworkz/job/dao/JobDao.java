package com.xworkz.job.dao;

import com.xworkz.job.dto.EducationDto;
import com.xworkz.job.dto.PersonalDto;

import java.util.Optional;

public interface JobDao {
    boolean personalDataSave(PersonalDto personalDto);

    Optional<PersonalDto> getIdByName(int id);

    boolean educationDataSave(EducationDto educationDto);

    Optional<PersonalDto> getIdByPhone(long phone);

    //   boolean experienceDataSave(ExperienceDto experienceDto);
}
