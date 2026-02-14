package com.xworkz.module.dto;

import com.xworkz.module.entity.BatchEntity;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int studentId;

    private String studentName;

    private String email;
    private long phone;

    private int age;

    private String gender;

    private String qualification;

    private String collegeName;

    private String address;

    private String joinedDate;

    private boolean active;

   private int batchId;

}
