package com.xworkz.file;

import com.xworkz.file.config.FileConfiguration;
import com.xworkz.file.dto.FileDto;
import com.xworkz.file.service.FileService;
import com.xworkz.file.service.impl.FileServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FileRunner {
    public static void main(String[] args) {
        System.out.println("main started");


        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(FileConfiguration.class);

        FileDto fileDto=new FileDto(2,"darshi","pdf","1.5MB");

        FileService fileService=applicationContext.getBean(FileServiceImpl.class);
        fileService.validateAndSave(fileDto);

        System.out.println("main ended");
    }
}
