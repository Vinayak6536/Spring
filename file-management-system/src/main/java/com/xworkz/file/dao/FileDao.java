package com.xworkz.file.dao;

import com.xworkz.file.dto.FileDto;

public interface FileDao {
    boolean save(FileDto fileDto);
}
