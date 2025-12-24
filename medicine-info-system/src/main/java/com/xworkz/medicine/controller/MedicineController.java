package com.xworkz.medicine.controller;

import com.xworkz.medicine.dto.MedicineDto;
import com.xworkz.medicine.service.MedicineService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

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
            return "MedicineResult";
        } else {
            return "Error";
        }

    }

    @GetMapping("/search")
    public String searchMedicineName(@RequestParam("query") String medicineName, Model model) {



        Optional<MedicineDto> medicineDto = medicineService.getMedicineByMedicineName(medicineName);

        if (medicineDto.isPresent()) {
            model.addAttribute("medicine", medicineDto.get());

            // using prefix("/") and suffix(".jsp") in configuration file.
            return "Search";
        } else {
            //model.addAttribute("err",medicineDto.get());
            return "Error";
        }

    }

    //Key Passing attribute using @RequstingParam
   /* @GetMapping("getMedicine")
    public String getMedicineId(@RequestParam("medicineId") String medicineId, Model model) {

        System.out.println(medicineId);

        Optional<MedicineDto> dto = medicineService.getMedicineId(Integer.parseInt(medicineId));
        if (dto.isPresent()) {
            model.addAttribute("medicine", dto.get());
            return "UpdateMedicine.jsp";
        } else {
            return "Error.jsp";
        }

    } */

    //Direct Value Passing using @PathVariable
    @GetMapping("/getMedicine/{anything}")
    public String getMedicineId(@PathVariable("anything") String medicineId, Model model) {
        System.out.println(medicineId);

        Optional<MedicineDto> dto = medicineService.getMedicineId(Integer.parseInt(medicineId));
        if (dto.isPresent()) {
            model.addAttribute("medicine", dto.get());
            return "UpdateMedicine";
        } else {
            return "Error";
        }
    }


    @PostMapping("update")
    public String updateMedicine(MedicineDto medicineDto) {
        System.out.println(medicineDto);

        boolean updated = medicineService.validateAndUpdate(medicineDto);

        if (updated) {
            System.out.println("Details Updated");
            return "MedicineResult";
        } else {
            return "Error";
        }

    }


}
