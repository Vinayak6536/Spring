package com.xworkz.module.controller;

import com.xworkz.module.dto.XworkzDto;
import com.xworkz.module.service.XworkzService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class XworkzController {
    @Autowired
    private XworkzService xworkzService;
    public XworkzController(){
        System.out.println("Running Controller.......");
    }

    @PostMapping("signUp")
    public String getSignUp(XworkzDto xworkzDto){
        if (xworkzDto != null){
            xworkzService.validateAndSave(xworkzDto);

            return "SignIn";
        }
        return "SignUp";
    }

    @GetMapping("signIn")
    public String getSignIn(String emailOrPhone, String password, Model model){
        System.out.println(emailOrPhone);
        System.out.println(password);
        XworkzDto xworkzDto=xworkzService.findEmail(emailOrPhone,password);
        System.out.println(xworkzDto);
        if (xworkzDto != null) {
            model.addAttribute("Success", xworkzDto);

            return "index";
        }
        return "SignUp";
    }
}
