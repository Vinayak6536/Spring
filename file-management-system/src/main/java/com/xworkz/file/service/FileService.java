package com.xworkz.file.service;

import com.xworkz.file.dto.FileDto;

public interface FileService {
    boolean validateAndSave(FileDto fileDto);
}
