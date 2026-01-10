package com.xworkz.medicine.controller;

import com.xworkz.medicine.dto.MedicineDto;
import com.xworkz.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    public MedicineController() {
        System.out.println("Created MedicineController");
    }

    @PostMapping("/addMedicine")
    public String addMedicine(MedicineDto dto) {
        System.out.println(dto);
        boolean medicineSaved = medicineService.validateAndSave(dto);
        if (medicineSaved) {
            System.out.println("Ok");
            return "MedicineResult.jsp";
        } else {
            return "Error";
        }

    }
}
