package com.xworkz.medicine.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "medicine")

public class MedicineDto {
    @Id
    @Column(name = "id")
    private int medicineId;
    @Column(name = "medicineName")
    private String medicineName;

    @Column(name = "medicinePrice")
    private String medicinePrice;

    @Column(name = "mg")
    private String mg;

    @Column(name = "combination")
    private String combination;

    @Column(name = "expiryDate")
    private String expiryDate;
}
