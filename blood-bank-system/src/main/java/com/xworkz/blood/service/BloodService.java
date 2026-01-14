package com.xworkz.blood.service;

import com.xworkz.blood.dto.BloodDto;
import com.xworkz.blood.entity.BloodEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BloodService {
    boolean validateAndSave(BloodDto dto);

    boolean updateAndSave(BloodDto dto);

    boolean deleted(String  id);

    List<BloodEntity> findByFirstName(String firstName);


}
