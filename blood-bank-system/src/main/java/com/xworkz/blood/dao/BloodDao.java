package com.xworkz.blood.dao;

import com.xworkz.blood.entity.BloodEntity;

import java.util.List;

public interface BloodDao {
    boolean save(BloodEntity entity);

    boolean updatedSave(BloodEntity entity);

    boolean deleted(String id);

    List<BloodEntity> findByFirstName(String firstName);
}
