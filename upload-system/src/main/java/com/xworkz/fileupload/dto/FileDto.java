package com.xworkz.fileupload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private String name;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }
}
