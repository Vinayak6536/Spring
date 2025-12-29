package com.xworkz.blood.dao;

import com.xworkz.blood.dto.BloodDto;

import java.util.List;

public interface BloodDao {
    boolean save(BloodDto dto);

    boolean updatedSave(BloodDto dto);

    boolean deleted(String firstName);

    List<BloodDto> findByFirstName(String firstName);
}
