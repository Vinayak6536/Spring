package com.xworkz.zomato.controller;

import com.xworkz.zomato.dto.ZomatoDto;
import com.xworkz.zomato.service.ZomatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Component
@RequestMapping("/")
public class ZomatoController {
    @Autowired
    private ZomatoService zomatoService;

    public ZomatoController(){
        System.out.println("Execute ZomatoController....");
    }

    @PostMapping("/addZomato")
    public String  addZomato(ZomatoDto zomatoDto){
        System.out.println("Add Zomato Restaurant");
        boolean addData=zomatoService.validateAndSave(zomatoDto);
        if (addData){
            System.out.println("Saved Successfully");
            return "ZomatoResult.jsp";
        }
        else {
            return "Error.jsp";
        }
    }

    @GetMapping("/search")
   public String getPhoneNo(@RequestParam("phone") Long phoneNo, Model model){

        Optional<ZomatoDto> zomatoDto=zomatoService.getNameByPhoneNo(phoneNo);

        if (zomatoDto.isPresent()){
            model.addAttribute("phone",zomatoDto.get());
            return "Search.jsp";
        }

        return "Error.jsp";
    }

}
