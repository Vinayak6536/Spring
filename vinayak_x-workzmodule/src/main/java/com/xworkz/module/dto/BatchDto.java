package com.xworkz.module.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {
    //@NotNull(message = "Batch ID is required")
    private Integer batchId;

    @NotBlank(message = "Batch name is required")
    @Size(min = 3, max = 50, message = "Batch name must be between 3 and 50 characters")
    private String batchName;

    @NotBlank(message = "Batch start date is required")
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}",
            message = "Batch start date must be in yyyy-MM-dd format"
    )
    private String batchStartDate;

    @NotBlank(message = "Batch end date is required")
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}",
            message = "Batch end date must be in yyyy-MM-dd format"
    )
    private String batchEndDate;

    @NotBlank(message = "Batch trainer name is required")
    @Size(min = 3, max = 40, message = "Trainer name must be between 3 and 40 characters")
    private String batchTrainer;

   // private MultipartFile file;
}
