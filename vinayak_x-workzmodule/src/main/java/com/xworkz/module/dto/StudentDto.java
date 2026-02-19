package com.xworkz.module.dto;

import com.xworkz.module.entity.BatchEntity;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int studentId;

    @NotBlank(message = "Student name is required")
    @Size(min = 3, max = 50, message = "Name must be 3 to 50 characters")
    private String studentName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Phone number is required")
    @Digits(integer = 10, fraction = 0, message = "Phone must be 10 digits")
    private long phone;

    @NotNull(message = "Age is required")
    @Min(value = 16, message = "Minimum age is 16")
    @Max(value = 60, message = "Maximum age is 60")
    private int age;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    @NotBlank(message = "College name is required")
    private String collegeName;

    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 200, message = "Address must be 5 to 200 characters")
    private String address;

    @NotBlank(message = "Joined date is required")
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}",
            message = "Date must be yyyy-MM-dd format"
    )
    private String joinedDate;

    private boolean active;

    // ✅ FK reference
    @NotNull(message = "Batch is required")
    private int batchId;

    // ✅ Image upload
    private MultipartFile file;

    // ✅ Image path for display
    private String imagePath;

}
