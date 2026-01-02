package com.xworkz.job.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EducationDto {

    private int id;
    private String schoolName;
    private double schoolPerc;
    private String collegeName;
    private double collegePerc;
    private String degreeName;
    private double degreePerc;
    private String masterName;
    private double masterPerc;
}
