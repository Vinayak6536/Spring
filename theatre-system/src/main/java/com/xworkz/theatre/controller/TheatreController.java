package com.xworkz.theatre.controller;

import com.xworkz.theatre.dto.TheatreDto;
import com.xworkz.theatre.entity.TheatreEntity;
import com.xworkz.theatre.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    public TheatreController() {
        System.out.println("Running Theatre Controller");
    }

    @PostMapping("addTheatre")
    public String addTheatre(TheatreDto theatreDto){
        boolean saved=theatreService.validateAndSave(theatreDto);
        if (saved){
            return "AddTheatreResult";
        }
        return "Error";
    }

    @GetMapping("viewTheatres")
    public String viewTheatres(Model model){
    //    System.out.println("view page");
        List<TheatreDto> theatreDtos = theatreService.viewTheatres();
        model.addAttribute("theatres",theatreDtos);
    //    System.out.println(theatreDtos);
        return "ViewTheatres";
    }

    @GetMapping("editTheatre/{theatreId}")
    public String editTheatres(@PathVariable("theatreId")int id, Model model){
        System.out.println(id);
        Optional<TheatreDto> theatreDto=theatreService.editTheatre(id);
        if (theatreDto.isPresent()) {
            model.addAttribute("theatre", theatreDto.get());
            System.out.println(theatreDto);
            return "UpdateTheatre";
        }
        return "Error";
    }

    @PostMapping("updateTheatre")
    public String updateTheatre(TheatreDto theatreDto){
        boolean updated=theatreService.updateTheatre(theatreDto);
        if (updated){
            return "AddTheatreResult";
        }
        return "Error";
    }

    @GetMapping("deleteTheatre/{theatreId}")
    public String deleteTheatre(@PathVariable("theatreId")int id){
        boolean deleted=theatreService.deleteTheatre(id);
        if (deleted){
            return "AddTheatreResult";
        }
        return "Error";
    }
}
