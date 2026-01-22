package com.xworkz.module.controller;

import com.xworkz.module.dto.XworkzDto;
import com.xworkz.module.service.XworkzService;

import com.xworkz.module.util.OTPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Random;

@Controller
public class XworkzController {
    @Autowired
    private XworkzService xworkzService;
    public XworkzController(){
        System.out.println("Running Controller.......");
    }

    @PostMapping("signUp")
    public ModelAndView getSignUp(@Valid XworkzDto xworkzDto, BindingResult result,ModelAndView model){
        if (result.hasErrors()){
            result.getFieldErrors().forEach(fieldError -> model.addObject(fieldError.getField() +"Error",fieldError.getDefaultMessage()));
            model.setViewName("SignUp");
            return model;
        }
        if (!xworkzService.checkEmailOrPhone(xworkzDto.getEmail()) && !xworkzService.checkEmailOrPhone(String.valueOf(xworkzDto.getPhoneNo())) && xworkzDto != null ){
            xworkzService.validateAndSave(xworkzDto);

            model.setViewName("SignIn");
            return model;

        }
        model.addObject("exist","User Already Exist");
        model.setViewName("SignUp");
        return model;
    }

    @GetMapping("signIn")
    public String getSignIn(String emailOrPhone, String password, Model model) {

        String fetchedPassword = xworkzService.findEmail(emailOrPhone, password);

        if (fetchedPassword != null) {
            model.addAttribute("Success", fetchedPassword);
            xworkzService.setCount(emailOrPhone);
            return "index";
        } else {
            int count = xworkzService.getCount(emailOrPhone);
            if (count >= 2) {
                return "ForgotPassword";
            } else {

                xworkzService.updateCount(emailOrPhone);

            }

            model.addAttribute("message", (3 - (count + 1))+" "+"Attempts Left");
            model.addAttribute("emailOrPhoneno", emailOrPhone);
            return "SignIn";
        }
    }

    @PostMapping("forgetPassword")
    public ModelAndView getOTP(@RequestParam("emailOrPhone")String emailOrPhone,ModelAndView model){
        Random random=new Random();
        int randaomOTP= random.nextInt(999999) + 100000;

        boolean isOtpSaved=xworkzService.saveOtp(emailOrPhone,randaomOTP);
        if (isOtpSaved){
            model.addObject("email",emailOrPhone);
            String subject="OTP Details";
            String text="Your OTP for Verification Is: "+randaomOTP;
            OTPUtil.sendSimpleMessage(emailOrPhone,subject,text);
            model.setViewName("ForgotPassword");
        }else {
            model.addObject("email",emailOrPhone);
        }
        return model;
    }

    @PostMapping("/verifyOtp")
    public ModelAndView verifyOtp(@RequestParam("otp") int otp,String emailOrPhone,ModelAndView model){
        boolean isOtpVerified=
    }
}
