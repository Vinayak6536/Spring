package com.xworkz.blood.dao;

import com.xworkz.blood.dto.BloodDto;
import com.xworkz.blood.entity.BloodEntity;

import java.util.List;

public interface BloodDao {
    boolean save(BloodEntity entity);

    boolean updatedSave(BloodEntity entity);

    boolean deleted(String firstName);

    List<BloodDto> findByFirstName(String firstName);
}
