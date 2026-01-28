package com.xworkz.module.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {
    private int batchId;
    private String batchName;
    private String batchYear;
    private String batchLeader;
}
