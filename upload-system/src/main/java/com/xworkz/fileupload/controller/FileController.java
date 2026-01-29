package com.xworkz.fileupload.controller;

import com.xworkz.fileupload.dto.FileDto;
import com.xworkz.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping("upload")
    public String fileUpload(@ModelAttribute FileDto fileDto)throws IOException{
        if (fileDto != null){

        }
    }
}
