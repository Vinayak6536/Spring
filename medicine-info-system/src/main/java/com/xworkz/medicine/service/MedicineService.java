package com.xworkz.medicine.service;

import com.xworkz.medicine.dto.MedicineDto;

public interface MedicineService {
    boolean validateAndSave(MedicineDto medicineDto);
}
