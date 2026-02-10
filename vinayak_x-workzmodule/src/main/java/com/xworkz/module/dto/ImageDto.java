package com.xworkz.module.dto;

import com.xworkz.module.entity.BatchEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private int logoId;

    private String logoName;
    private String logoType;

    private byte[] logoData;
    private BatchEntity batch;
}
