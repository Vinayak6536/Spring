package com.xworkz.fileupload.service;

import com.xworkz.fileupload.dto.FileDto;

import java.io.IOException;

public interface FileService {
    boolean validateAndSave(FileDto fileDto) throws IOException;
}
