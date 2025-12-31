package com.xworkz.zomato.controller;

import com.xworkz.zomato.dto.ZomatoDto;
import com.xworkz.zomato.service.ZomatoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class ZomatoController {
    @Autowired
    private ZomatoService zomatoService;

    public ZomatoController() {
        System.out.println("Execute ZomatoController....");
    }

    @PostMapping("addZomato")
    public String addZomato(ZomatoDto zomatoDto) {
        System.out.println("Add Zomato Restaurant");
        boolean addData = zomatoService.validateAndSave(zomatoDto);
        if (addData) {
            System.out.println("Saved Successfully");
            return "ZomatoResult";
        } else {
            return "Error";
        }
    }

    @GetMapping("search")
    public String getPhoneNo(@RequestParam("phone") Long phoneNo, Model model) {

        Optional<ZomatoDto> zomatoDto = zomatoService.getNameByPhoneNo(phoneNo);

        if (zomatoDto.isPresent()) {
            model.addAttribute("phone", zomatoDto.get());
            return "SearchResult";
        } else {

            return "Error";
        }
    }

    @GetMapping("editDetails/{name}")
    public String getRestaurantName(@PathVariable("name") String name, Model model) {

        Optional<ZomatoDto> zomatoDto = zomatoService.getRestaurantName(name);
        System.out.println(name);
        if (zomatoDto.isPresent()) {

            model.addAttribute("name", zomatoDto.get());
            return "UpdateRestaurant";
        } else {
            return "Error";
        }
    }

    @PostMapping("update")
    public String updateRestaurant(ZomatoDto zomatoDto) {

        boolean updated = zomatoService.updateAndSave(zomatoDto);

        if (updated) {
            return "ZomatoResult";
        } else {
            return "Error";
        }

    }

    @GetMapping("delete/{deleted}")
    public String deleteRestaurant(@PathVariable("deleted") String name, Model model) {

        boolean zomatoDto = zomatoService.deleteRestaurantName(name);
        System.out.println(name);
        if (zomatoDto) {

            model.addAttribute("name", zomatoDto);
            return "Success";
        } else {
            return "Error";
        }

    }
}
