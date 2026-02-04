package com.xworkz.fileupload.controller;

import com.xworkz.fileupload.dto.FileDto;
import com.xworkz.fileupload.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String fileUpload(@ModelAttribute FileDto fileDto)throws IOException{
//        System.out.println(fileDto.getFile().toString());
        if (fileDto != null){
            boolean isValid = fileService.validateAndSave(fileDto);

            if (isValid){
                System.out.println("Data Saved");
            }

        }
        return "";
    }
    @GetMapping("/viewData")
    public void getImage(HttpServletResponse response, @RequestParam String imagePath) throws IOException{
        response.setContentType("image/jpg");
        File file = new File(imagePath);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
        response.flushBuffer();
    }





}

