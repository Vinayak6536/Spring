package com.xworkz.medicine.dao;

import com.xworkz.medicine.dto.MedicineDto;

import java.util.List;
import java.util.Optional;

public interface MedicineDao {
    boolean save(MedicineDto medicineDto);

    boolean update(MedicineDto medicineDto);

    Optional<MedicineDto> getName(String medicineName);

    Optional<MedicineDto> getMedicineList(int medicineName);
}
