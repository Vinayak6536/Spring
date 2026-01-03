package com.xworkz.job.service.impl;

import com.xworkz.job.dao.JobDao;
import com.xworkz.job.dto.EducationDto;
import com.xworkz.job.dto.PersonalDto;
import com.xworkz.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;

    @Override
    public boolean validateAndSave(PersonalDto personalDto) {

        if (personalDto != null) {
            System.out.println("Name Service Method");
            return jobDao.personalDataSave(personalDto);
        }
        return false;
    }

    @Override
    public Optional<PersonalDto> validateAndFetch(String name) {
        if (name != null){
            return jobDao.getIdByName(name);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public boolean educationValidate(EducationDto educationDto) {
        if (educationDto.getSchoolName() == null || educationDto.getSchoolName().isEmpty()
                || educationDto.getSchoolName().length() > 100) {
            return false;
        }
        if (educationDto.getSchoolPerc() < 0 || educationDto.getSchoolPerc() > 100) {
            return false;
        }

        // College validation
        if (educationDto.getCollegeName() != null && !educationDto.getCollegeName().isEmpty()) {
            if (educationDto.getCollegeName().length() > 100) return false;
            if (educationDto.getCollegePerc() < 0 || educationDto.getCollegePerc() > 100) return false;
        }

        // Degree validation
        if (educationDto.getDegreeName() != null && !educationDto.getDegreeName().isEmpty()) {
            if (educationDto.getDegreeName().length() > 100) return false;
            if (educationDto.getDegreePerc() < 0 || educationDto.getDegreePerc() > 100) return false;
        }

        // Master validation
        if (educationDto.getMasterName() != null && !educationDto.getMasterName().isEmpty()) {
            if (educationDto.getMasterName().length() > 100) return false;
            if (educationDto.getMasterPerc() < 0 || educationDto.getMasterPerc() > 100) return false;
        }

        return jobDao.educationDataSave(educationDto);
    }
}
