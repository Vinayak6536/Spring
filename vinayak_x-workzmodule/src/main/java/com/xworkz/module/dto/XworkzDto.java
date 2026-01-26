package com.xworkz.module.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XworkzDto {

        private int id;

        @NotBlank(message = "First name is required")
        @Pattern(regexp = "^[A-Za-z]+$", message = "First name must contain only letters")
        private String firstName;

        @NotBlank(message = "Last name is required")
        @Pattern(regexp = "^[A-Za-z]+$", message = "Last name must contain only letters")
        private String lastName;

        @Min(value = 18, message = "Age must be at least 18")
        @Max(value = 120, message = "Age must be less than 120")
        private int age;

        @NotBlank(message = "Gender is required")
        private String gender;

        @NotNull(message = "Phone number is required")
        @Min(value = 6000000000L, message = "Invalid phone number")
        @Max(value = 9999999999L, message = "Invalid phone number")
        private long phoneNo;

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        private String email;

        @NotBlank(message = "Password is required")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$",
                message = "Password must contain uppercase, lowercase, number & special character"
        )
        private String password;

        @NotBlank(message = "Confirm password is required")
        private String confirmPassword;

    }


