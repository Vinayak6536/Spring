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
    public String getSignUp(XworkzDto xworkzDto,Model model){
        if (!xworkzService.checkEmailOrPhone(xworkzDto.getEmail()) && !xworkzService.checkEmailOrPhone(String.valueOf(xworkzDto.getPhoneNo())) && xworkzDto != null ){
            xworkzService.validateAndSave(xworkzDto);

            return "SignIn";
        }
        model.addAttribute("exist","User Already Exist");
        return "SignUp";
    }

    @GetMapping("signIn")
    public String getSignIn(String emailOrPhone, String password, Model model){

        String fetchedPassword=xworkzService.findEmail(emailOrPhone,password);

        if (fetchedPassword != null) {
            model.addAttribute("Success", fetchedPassword);
            xworkzService.setCount(emailOrPhone);
            return "index";
        }

        else {
            int count=xworkzService.getCount(emailOrPhone);
            if (count>=2){
                return "ForgetPassword";
            }else {
                xworkzService.updateCount(emailOrPhone);
            }
        }

        model.addAttribute("emailOrPhoneno",emailOrPhone);
        return "SignIn";
    }

}
