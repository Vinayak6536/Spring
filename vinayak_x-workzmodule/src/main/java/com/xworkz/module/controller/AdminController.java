package com.xworkz.module.controller;

import com.xworkz.module.dto.BatchDto;
import com.xworkz.module.service.admin.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private BatchService batchService;

    @PostMapping("addBatch")
    public ModelAndView addBatch(@Valid @ModelAttribute("batch") BatchDto batchDto, BindingResult bindingResult , ModelAndView modelAndView){
        System.out.println(batchDto);
        if (bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(fieldError -> modelAndView.addObject(fieldError.getField() + "Error",fieldError.getDefaultMessage()));
            modelAndView.setViewName("AddBatch");
            return modelAndView;
        }

        if (batchDto != null){
            System.out.println(batchDto);
            batchService.validateAndSave(batchDto);
            modelAndView.addObject("success","Batch Added Successfully");
            modelAndView.setViewName("AdminPage");
        }else {
            System.out.println("Dto is null");
        }
        return modelAndView;
    }

    @GetMapping("batchList")
    public String getBatchList(Model model) {
        List<BatchDto> batchList = batchService.getBatchList();

        System.out.println("BATCH LIST SIZE = " + batchList.size());
        batchList.forEach(System.out::println);

        model.addAttribute("batchList", batchList);
        return "BatchList";
    }
}
