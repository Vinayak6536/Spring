package com.xworkz.module.controller;

import com.xworkz.module.dto.XworkzDto;
import com.xworkz.module.service.xworkz.XworkzService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Random;

@Controller
public class XworkzController {
    @Autowired
    private XworkzService xworkzService;


    public XworkzController() {
        System.out.println("Running Controller.......");
    }

    @RequestMapping("forgotPassword")
    public String forgotPassword(){
        return "ForgotPassword";
    }

    @PostMapping("signUp")
    public ModelAndView getSignUp(@Valid XworkzDto xworkzDto, BindingResult result, ModelAndView model) {
        System.out.println(xworkzDto);
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(fieldError -> model.addObject(fieldError.getField() + "Error", fieldError.getDefaultMessage()));
            model.setViewName("SignUp");
            return model;
        }
        if (!xworkzService.checkEmailOrPhone(xworkzDto.getEmail()) && !xworkzService.checkEmailOrPhone(String.valueOf(xworkzDto.getPhoneNo())) && xworkzDto != null) {
            xworkzService.validateAndSave(xworkzDto);

            model.setViewName("AdminLogin");
            return model;

        }
        model.addObject("exist", "User Already Exist");
        model.setViewName("SignUp");
        return model;
    }

    @GetMapping("AdminLogin")
    public String getAdminLogin(String emailOrPhone, String password, Model model, HttpSession session) {

        if (xworkzService.checkEmailOrPhone(emailOrPhone)) {
            XworkzDto xworkzDto = xworkzService.findEmail(emailOrPhone, password);

            if (xworkzDto != null) {
                System.out.println("Admin Details" + xworkzDto);
                session.setAttribute("admin", xworkzDto);
                model.addAttribute("Success", xworkzDto);
                session.setAttribute("fromBatch", false);
                xworkzService.setCount(emailOrPhone);
                return "AdminPage";
            } else {
                int count = xworkzService.getCount(emailOrPhone);
                if (count >= 2) {
                    model.addAttribute("emailOrPhoneno", emailOrPhone);
                    return "ForgotPassword";
                } else {

                    xworkzService.updateCount(emailOrPhone);

                }
                model.addAttribute("message", (3 - (count + 1)) + " " + "Attempts Left");
                model.addAttribute("wrongPassword", "Incorrect password");
                model.addAttribute("emailOrPhoneno", emailOrPhone);
                return "AdminLogin";
            }
        } else {

            model.addAttribute("notExist", "Email or Phone Number does not exist");
            return "AdminLogin";

        }
    }

    @PostMapping("forgetPassword")
    public ModelAndView getOTP(@RequestParam("emailOrPhone") String emailOrPhone, @RequestParam String action, @RequestParam(value = "otp", required = false) Integer otp, ModelAndView model) {
        try {
            System.out.println(emailOrPhone);
            Random random = new Random();
            int randaomOTP = random.nextInt(900000) + 100000;

            //  boolean isOtpSaved = xworkzService.saveOtp(emailOrPhone, randaomOTP);
            // System.out.println(isOtpSaved);
            if ("sendOtp".equals(action)) {
                xworkzService.saveOtp(emailOrPhone, randaomOTP);
                model.addObject("email", emailOrPhone);
                model.addObject("success", "OTP sent successfully");
                model.addObject("otpSent", true);
                model.setViewName("ForgotPassword");
                return model;
            }

            if ("resendOtp".equals(action)) {
                xworkzService.saveOtp(emailOrPhone, randaomOTP);
                model.addObject("email", emailOrPhone);
                model.addObject("success", "OTP resent successfully");
                model.addObject("resendDisabled", true);
                model.addObject("otpSent", true);
                model.setViewName("ForgotPassword");
                return model;
            }

            if ("verifyOtp".equals(action)) {
                boolean isOtpVerified = xworkzService.verifyOtp(emailOrPhone, otp);
                if (isOtpVerified) {
                    model.addObject("verifyOtp", "OTP Verification Successfully");
                    model.addObject("emailOrPhone", emailOrPhone);
                    model.setViewName("ResetPassword");
                    return model;
                } else {
                    model.addObject("otpVerify", "Invalid OTP");
                    model.setViewName("ForgotPassword");
                    return model;
                }
            } else {
                model.addObject("email", emailOrPhone);
                model.addObject("otpVerify", "Invalid OTP");
                model.setViewName("ForgotPassword");
                return model;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.setViewName("ForgotPassword");
        return model;
    }

//    @GetMapping("/verifyOtp")
//    public ModelAndView verifyOtp(@RequestParam int otp, @RequestParam("emailOrPhone") String emailOrPhone, ModelAndView model){
//        boolean isOtpVerified=xworkzService.verifyOtp(emailOrPhone,otp);
//        if (isOtpVerified){
//            model.addObject("verifyOtp","OTP Verification Successfully");
//            model.setViewName("ResetPassword");
//        }
//        else {
//            model.addObject("otpVerify","Invalid OTP");
//            model.setViewName("ForgotPassword");
//        }

    /// /        model.addObject()
//        return model;
//    }
    @PostMapping("resetPassword")
    public ModelAndView resetPassword(@RequestParam String emailOrPhone, String password, String confirmPassword, ModelAndView model) {

        boolean updated = xworkzService.resetPassword(emailOrPhone, password, confirmPassword);
        if (updated) {
            model.addObject("updatePassword", "Reset Password Successfully");
            model.setViewName("AdminLogin");
            return model;
        }
        return model;
    }

    @GetMapping("viewProfile")
    public String viewProfileByEmali(@RequestParam("email") String email, HttpSession session) {
        if (email != null) {
            XworkzDto xworkzDto = xworkzService.viewProfileByEmail(email);
            session.setAttribute("viewProfile", xworkzDto);
            return "AdminProfileDetails";
        }
        return null;
    }

    @GetMapping("editProfile")
    public String editProfileByEmali(@RequestParam("email") String email, HttpSession session) {
        if (email != null) {
            XworkzDto xworkzDto = xworkzService.viewProfileByEmail(email);
            session.setAttribute("viewProfile", xworkzDto);
            return "UpdateAdminProfile";
        }
        return null;
    }

    @PostMapping("updateAdminProfile")
    public String updateAdminProfile(XworkzDto xworkzDto, Model model) {
        if (xworkzDto != null) {
            xworkzService.updateAdminProfile(xworkzDto);
            model.addAttribute("success", "Admin Profile Updated Successfully");
            return "UpdateAdminProfile";
        }
        model.addAttribute("fail", "Admin Profile not Updated");
        return "UpdateAdminProfile";
    }


    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "AdminLogin";
    }
}
