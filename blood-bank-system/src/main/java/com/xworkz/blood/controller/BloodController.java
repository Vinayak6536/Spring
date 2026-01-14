package com.xworkz.blood.controller;

import com.xworkz.blood.dto.BloodDto;
import com.xworkz.blood.entity.BloodEntity;
import com.xworkz.blood.service.BloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BloodController {

    @Autowired
    private BloodService bloodService;

    public BloodController(){
        System.out.println("Running BloodController...");
    }

    @PostMapping("/createAccount")
    public String addRegister(BloodDto bloodDto) {
        System.out.println("Add Register");
        System.out.println(bloodDto);
        boolean saved = bloodService.validateAndSave(bloodDto);
        if (saved) {
            return "Success";
        } else {
            return "Error";
        }
    }

    @GetMapping("/searchByFirstName")
    public String searchByFirstName(@RequestParam("firstName") String firstName, Model model) {

        List<BloodEntity> searchByFirstNameone = bloodService.findByFirstName(firstName);
        System.out.println(searchByFirstNameone);
        model.addAttribute("donorList", searchByFirstNameone);
        return "Result";

}

    @GetMapping("/editBlood")
    public String editBlood(@RequestParam("firstName")String firstName, Model model) {
        System.out.println(firstName);
        List<BloodEntity> searchByFirstNameTwo = bloodService.findByFirstName(firstName);
        if (!searchByFirstNameTwo.isEmpty()) {
            model.addAttribute("donor", searchByFirstNameTwo.get(0));
            return "UpdateDonor";
        }
        return "Error";
    }

    @PostMapping("/updateBlood")
    public String updateDetails(BloodDto bloodDto){
        boolean saved = bloodService.updateAndSave(bloodDto);
        if (saved) {
            return "Success";
        } else {
            return "Error";
        }
    }

    @GetMapping("/delete")
    public String deleteDetails(@RequestParam("donorId")String id, Model model){
        System.out.println(id);
        boolean searchByFirstNameTwo = bloodService.deleted(id);
        if (searchByFirstNameTwo) {
            model.addAttribute("donor", searchByFirstNameTwo);
            return "Success";
        }
        return "Error";
    }
}
