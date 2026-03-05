package com.xworkz.forms.controller;

import com.xworkz.forms.dto.PersonalLoanDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ValidationController {

    @PostMapping("save")
    public ModelAndView savePerson(
            @Valid PersonalLoanDto personalLoanDto,
            BindingResult errors,
            ModelAndView model) {

//        if (errors.hasErrors()) {
//            if (errors.getFieldError("firstName") != null) {
//                model.addObject("nameError",
//                        errors.getFieldError("firstName").getDefaultMessage());
//            }
//
//            if (errors.getFieldError("lastName") != null) {
//                model.addObject("nameError1",
//                        errors.getFieldError("lastName").getDefaultMessage());
//            }
//
//            if (errors.getFieldError("age") != null) {
//                model.addObject("nameError2",
//                        errors.getFieldError("age").getDefaultMessage());
//            }
//
//            if (errors.getFieldError("address") != null) {
//                model.addObject("nameError3",
//                        errors.getFieldError("address").getDefaultMessage());
//            }
//
//            if (errors.getFieldError("adharNo") != null) {
//                model.addObject("nameError4",
//                        errors.getFieldError("adharNo").getDefaultMessage());
//            }
//
//            if (errors.getFieldError("state") != null) {
//                model.addObject("nameError5",
//                        errors.getFieldError("state").getDefaultMessage());
//            }
//
//            if (errors.getFieldError("country") != null) {
//                model.addObject("nameError6",
//                        errors.getFieldError("country").getDefaultMessage());
//            }

        if (errors.hasErrors()) {
            errors.getFieldErrors().forEach(error ->
                    model.addObject(error.getField() + "Error",
                            error.getDefaultMessage())
            );

            model.setViewName("index");
            return model;
        }
        model.setViewName("index");
        return model;
    }
}
