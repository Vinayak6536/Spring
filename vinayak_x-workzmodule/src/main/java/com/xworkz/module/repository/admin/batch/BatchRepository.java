package com.xworkz.module.repository.admin.batch;

import com.xworkz.module.entity.BatchEntity;
import com.xworkz.module.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface BatchRepository {
    boolean save(BatchEntity batchEntity);

    List<BatchEntity> getBatchList();

    Optional<BatchEntity> getBatchDetails(int batchId);

    Optional<BatchEntity> getBatchId(int batchId);
}
