package com.xworkz.module.service.admin.batch.impl;

import com.xworkz.module.dto.BatchDto;
import com.xworkz.module.entity.BatchEntity;
import com.xworkz.module.entity.ImageEntity;
import com.xworkz.module.repository.admin.batch.BatchRepository;
import com.xworkz.module.service.admin.batch.BatchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private BatchEntity batchEntity;

    @Autowired
    private ImageEntity imageEntity;

    @Override
    public boolean validateAndSave(BatchDto batchDto) throws IOException {
        if (batchDto != null) {

            MultipartFile multipartFile=batchDto.getFile();
            BeanUtils.copyProperties(batchDto,batchEntity);
            String uploadDir = "V:/Spring/GitBash/Spring/vinayak_x-workzmodule/UploadedImages/";

            String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();

            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, multipartFile.getBytes());



            imageEntity.setOriginalName(multipartFile.getOriginalFilename());
            imageEntity.setFileSize(multipartFile.getSize());
            imageEntity.setImagePath(fileName);
            imageEntity.setContentType(multipartFile.getContentType());

            imageEntity.setBatch(batchEntity);

            batchEntity.setImageLogo(imageEntity);

           return batchRepository.save(batchEntity);
        }
        return false;
    }

    @Override
    public List<BatchDto> getBatchList() {

        List<BatchEntity> entityList = batchRepository.getBatchList();
        System.out.println(entityList);
        List<BatchDto> dtoList = new ArrayList<>();

        for (BatchEntity entity : entityList) {
            System.out.println(entity.getStudents());
            BatchDto dto = new BatchDto();
            BeanUtils.copyProperties(entity, dto);

            // ✅ IMPORTANT: set image path manually
            if (entity.getImageLogo() != null) {
                dto.setImagePath(entity.getImageLogo().getImagePath());
            }

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
