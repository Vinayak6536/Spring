package com.xworkz.module.controller;

import com.xworkz.module.dto.XworkzDto;
import com.xworkz.module.service.xworkz.XworkzService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.util.Random;

@Controller
public class XworkzController {
    @Autowired
    private XworkzService xworkzService;


    public XworkzController() {
        System.out.println("Running Controller.......");
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("forgotPassword")
    public String forgotPassword(){
        return "ForgotPassword";
    }

    @RequestMapping("signUp")
    public String signUp(){
        return "SignUp";
    }

    @RequestMapping("adminLogin")
    public String adminLogin(){
        return "AdminLogin";
    }

    @PostMapping("signUp")
    public ModelAndView getSignUp(@ModelAttribute @Valid XworkzDto xworkzDto, BindingResult result, ModelAndView model) throws IOException {
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
                session.setAttribute("viewProfile", xworkzDto.getPath());
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
    public String viewProfileByEmail(@RequestParam("email") String email,
                                     HttpSession session) throws IOException{

        if (email != null) {
            XworkzDto dto = xworkzService.viewProfileByEmail(email);

            session.setAttribute("viewProfile", dto);
            session.setAttribute("isEdit", false);

            return "AdminProfileDetails";
        }
        return "redirect:/";
    }

    @GetMapping("/profileImage")
    public void getProfileImage(@RequestParam("fileName") String fileName,
                                HttpServletResponse response) throws IOException {

        String uploadDir = "V:/Spring/GitBash/Spring/vinayak_x-workzmodule/UploadedImages/";
        File file = new File(uploadDir + fileName);

        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Detect correct image type automatically
        String contentType = Files.probeContentType(file.toPath());
        response.setContentType(contentType);

        try (InputStream in = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {

            IOUtils.copy(in, out);
            out.flush();
        }
    }


    @GetMapping("editProfile")
    public String editProfileByEmali(@RequestParam("email") String email, Model model,HttpSession session)throws IOException {
        System.out.println("Edit profile first");
        if (email != null) {
            XworkzDto dto = xworkzService.viewProfileByEmail(email);
            System.out.println(dto);
            session.setAttribute("admin",dto);
            System.out.println("Edit profile page");
            model.addAttribute("editProfile", dto);
            model.addAttribute("profileImage",dto.getFile());
            model.addAttribute("isEdit",true);

            return "UpdateAdminProfile";
        }
        return "redirect:/adminProfileDetails";
    }

    @PostMapping("updateAdminProfile")
    public String updateAdminProfile(@ModelAttribute  XworkzDto xworkzDto, @RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (xworkzDto != null) {
         //   System.out.println(xworkzDto.getFile());
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
