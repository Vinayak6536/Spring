package com.xworkz.medicine.service;

import com.xworkz.medicine.dto.MedicineDto;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    boolean validateAndSave(MedicineDto medicineDto);

    boolean validateAndUpdate(MedicineDto medicineDto);

    Optional<MedicineDto> getMedicineByMedicineName(String medicineName);

    Optional<MedicineDto> getMedicineId(int medicineId);
}
