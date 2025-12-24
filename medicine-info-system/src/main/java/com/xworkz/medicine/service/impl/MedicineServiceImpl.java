package com.xworkz.medicine.service.impl;

import com.xworkz.medicine.dao.MedicineDao;
import com.xworkz.medicine.dto.MedicineDto;
import com.xworkz.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineDao medicineDao;

    public MedicineServiceImpl() {
        System.out.println("Created Medicine ServiceImpl.......");
    }


    @Override
    public boolean validateAndSave(MedicineDto medicineDto) {
        boolean isValid = false;

        if (medicineDto != null) {
            if (medicineDto.getMedicineName().trim().isEmpty()) {
                System.out.println("Enter Valid Name");
                isValid = true;
            } else if (medicineDto.getMedicinePrice().trim().isEmpty()) {
                System.out.println("Enter valid Price");
                isValid = true;
            } else if (medicineDto.getMg().trim().isEmpty()) {
                System.out.println("Enter Valid Mg");
                isValid = true;
            } else if (medicineDto.getCombination().trim().isEmpty()) {
                System.out.println("Enter valid Combination");
                isValid = true;
            } else if (medicineDto.getExpiryDate().trim().isEmpty()) {
                System.out.println("Enter Valid ExpiryDate");
                isValid = true;
            } else {
                isValid = true;
                return medicineDao.save(medicineDto);
            }
        }

        return isValid;
    }

    @Override
    public Optional<MedicineDto> getMedicineByMedicineName(String medicineName) {

        if (medicineName != null) {
            return medicineDao.getName(medicineName);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<MedicineDto> getMedicineId(int medicineId) {

        if (medicineId != 0) {
            System.out.println("Medicine fetched");
            Optional<MedicineDto> medicineDtos = medicineDao.getMedicineList(medicineId);
            return medicineDtos;
        } else {
            System.out.println("Not Found Medicine Details..");
        }


        return Optional.empty();
    }

    @Override
    public boolean validateAndUpdate(MedicineDto medicineDto) {
        boolean isValid = false;

        if (medicineDto != null) {
            if (medicineDto.getMedicineName().trim().isEmpty()) {
                System.out.println("Enter Valid Name");
                isValid = true;
            } else if (medicineDto.getMedicinePrice().trim().isEmpty()) {
                System.out.println("Enter valid Price");
                isValid = true;
            } else if (medicineDto.getMg().trim().isEmpty()) {
                System.out.println("Enter Valid Mg");
                isValid = true;
            } else if (medicineDto.getCombination().trim().isEmpty()) {
                System.out.println("Enter valid Combination");
                isValid = true;
            } else if (medicineDto.getExpiryDate().trim().isEmpty()) {
                System.out.println("Enter Valid ExpiryDate");
                isValid = true;
            } else {
                return medicineDao.update(medicineDto);
            }
        }

        return isValid;
    }
}

