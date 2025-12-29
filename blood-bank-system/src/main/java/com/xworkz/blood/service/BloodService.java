package com.xworkz.blood.service;

import com.xworkz.blood.dto.BloodDto;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public interface BloodService {
    boolean validateAndSave(BloodDto dto);

    boolean updateAndSave(BloodDto dto);

    boolean deleted(String firstName);

    List<BloodDto> findByFirstName(String firstName);


}
