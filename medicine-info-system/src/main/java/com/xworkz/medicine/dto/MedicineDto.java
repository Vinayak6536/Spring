package com.xworkz.medicine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDto {
    private int medicineId;
    private String medicineName;
    private String medicinePrice;
    private String mg;
    private String combination;
    private String expiryDate;
}
