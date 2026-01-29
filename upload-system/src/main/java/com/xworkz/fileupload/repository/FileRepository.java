package com.xworkz.fileupload.repository;

import com.xworkz.fileupload.entity.FileEntity;

public interface FileRepository {
    boolean save(FileEntity fileEntity);
}
