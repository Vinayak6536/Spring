package com.xworkz.medicine.service.impl;

import com.xworkz.medicine.dao.MedicineDao;
import com.xworkz.medicine.dto.MedicineDto;
import com.xworkz.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineDao medicineDao;

    public MedicineServiceImpl(){
        System.out.println("Created Medicine ServiceImpl.......");
    }


    @Override
    public boolean validateAndSave(MedicineDto medicineDto) {
        boolean isValid=false;

        if (medicineDto != null){
            if (medicineDto.getMedicineName().trim().isEmpty()){
                System.out.println("Enter Valid Name");
                isValid=true;
            } else if (medicineDto.getMedicinePrice().trim().isEmpty()) {
                System.out.println("Enter valid Price");
                isValid=true;
            } else if (medicineDto.getMg().trim().isEmpty()) {
                System.out.println("Enter Valid Mg");
                isValid=true;
            } else if (medicineDto.getCombination().trim().isEmpty()) {
                System.out.println("Enter valid Combination");
                isValid=true;
            } else if (medicineDto.getExpiryDate().trim().isEmpty()) {
                System.out.println("Enter Valid ExpiryDate");
                isValid=true;
            }
            else {
                isValid=true;
               return medicineDao.save(medicineDto);
            }
        }

        return false;
    }
}
