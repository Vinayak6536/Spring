package com.xworkz.job.controller;

import com.xworkz.job.dto.EducationDto;
import com.xworkz.job.dto.ExperienceDto;
import com.xworkz.job.dto.PersonalDto;
import com.xworkz.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class JobController {
    public JobController(){
        System.out.println("Running Job Controller");
    }
    @Autowired
    private JobService jobService;

    @PostMapping("personal")
    public String addPersonal(PersonalDto personalDto,Model model){

        boolean saved= jobService.validateAndSave(personalDto);

        if (saved){
            model.addAttribute("firstName",personalDto.getFirstName());
            return "PersonalSuccess";
        }else {
            return "Error";
        }
    }

    @GetMapping("getName")
    public String getId(@RequestParam("firstName")String name, Model model){

        System.out.println(name);
        Optional<PersonalDto> personalDto=  jobService.validateAndFetch(name);
        if (personalDto.isPresent()){
            model.addAttribute("dto",personalDto.get());
            return "EducationDetails";
        }else {
            return "Error";
        }
    }

    @PostMapping("education")
    public String addEducation(EducationDto educationDto){

        boolean saved=jobService.educationValidate(educationDto);
        if (saved){
            return "Experience";
        }
        return "Error";

    }

    @PostMapping("experience")
    public String addExperience(ExperienceDto experienceDto){


        return "";
    }
}
