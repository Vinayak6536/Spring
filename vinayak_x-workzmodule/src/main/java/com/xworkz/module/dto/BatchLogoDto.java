package com.xworkz.module.dto;

import com.xworkz.module.entity.BatchEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchLogoDto {
    private int logoId;

    private String logoName;
    private String logoType;

    private byte[] logoData;
    private BatchEntity batch;
}
