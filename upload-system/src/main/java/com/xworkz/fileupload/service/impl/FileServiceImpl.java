package com.xworkz.fileupload.service.impl;

import com.xworkz.fileupload.dto.FileDto;
import com.xworkz.fileupload.entity.FileEntity;
import com.xworkz.fileupload.repository.FileRepository;
import com.xworkz.fileupload.service.FileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileEntity fileEntity;

    @Override
    public boolean validateAndSave(FileDto fileDto) throws IOException {
        MultipartFile file = fileDto.getFile();

        byte[] bytes=file.getBytes();

      Path path= Paths.get("V:\\FileUploader\\"+file.getOriginalFilename()+System.currentTimeMillis()+".jpg");
        System.out.println(path);
        Files.write(path,bytes);
        fileEntity.setOriginalFileName(file.getOriginalFilename());
        fileEntity.setFileData(file.getBytes());
        fileEntity.setContentType(file.getContentType());
        fileEntity.setPath(String.valueOf(path));
        fileEntity.setFileSize(file.getSize());
        return fileRepository.save(fileEntity);
    }
}
