package com.xworkz.file.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileDto {
    private int id;
    private String  fileName;
    private String fileType;
    private String fileSize;
}
