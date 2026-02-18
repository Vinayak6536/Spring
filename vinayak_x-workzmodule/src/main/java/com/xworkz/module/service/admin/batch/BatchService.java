package com.xworkz.module.service.admin.batch;

import com.xworkz.module.dto.BatchDto;
import com.xworkz.module.dto.StudentDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BatchService {
    boolean validateAndSave(BatchDto batchDto) throws IOException;

    List<BatchDto> getBatchList();

    Optional<BatchDto> getBatchDetails(int batchId);

    Optional<BatchDto> getBatchId(int batchId);
}
