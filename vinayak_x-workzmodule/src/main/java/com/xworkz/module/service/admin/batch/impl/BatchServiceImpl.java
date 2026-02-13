package com.xworkz.module.service.admin.batch.impl;

import com.xworkz.module.dto.BatchDto;
import com.xworkz.module.entity.BatchEntity;
import com.xworkz.module.repository.admin.batch.BatchRepository;
import com.xworkz.module.service.admin.batch.BatchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private BatchEntity batchEntity;
    @Override
    public boolean validateAndSave(BatchDto batchDto) {
        if (batchDto != null) {
            BeanUtils.copyProperties(batchDto,batchEntity);
           return batchRepository.save(batchEntity);
        }
        return false;
    }

    @Override
    public List<BatchDto> getBatchList() {

        List<BatchEntity> entityList = batchRepository.getBatchList();
        List<BatchDto> dtoList = new ArrayList<>();

        for (BatchEntity entity : entityList) {
            System.out.println(entity.getStudents());
            BatchDto dto = new BatchDto();
            BeanUtils.copyProperties(entity, dto);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Optional<BatchDto> getBatchDetails(int batchId) {

        if (batchId != 0){
            Optional<BatchEntity> batchDetails = batchRepository.getBatchDetails(batchId);
            if (batchDetails.isPresent()) {
                System.out.println(batchDetails);
                BatchDto batchDto = new BatchDto();
                BeanUtils.copyProperties(batchDetails.get(), batchDto);
                System.out.println(batchDto);
                return Optional.of(batchDto);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<BatchDto> getBatchId(int batchId) {
        Optional<BatchEntity> batchEntity1=batchRepository.getBatchId(batchId);
        BatchDto batchDto=new BatchDto();
        BeanUtils.copyProperties(batchEntity1.get(),batchDto);
        return Optional.of(batchDto);
    }
}
