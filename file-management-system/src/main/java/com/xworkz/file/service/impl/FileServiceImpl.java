package com.xworkz.file.service.impl;

import com.xworkz.file.dao.FileDao;
import com.xworkz.file.dto.FileDto;
import com.xworkz.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public boolean validateAndSave(FileDto fileDto) {
        boolean isValid=false;
        if (fileDto.getId() != 0){
            if (fileDto.getFileName() != null && !fileDto.getFileName().isEmpty()){
                if (fileDto.getFileType() != null && !fileDto.getFileType().isEmpty()){
                    if (fileDto.getFileSize() != null && !fileDto.getFileSize().isEmpty()){
                        isValid=true;
                        fileDao.save(fileDto);
                    } else System.out.println("Invalid Details");
                }

            }
        }

        return isValid;
    }
}
