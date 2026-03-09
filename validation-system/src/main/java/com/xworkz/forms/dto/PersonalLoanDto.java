package com.xworkz.forms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalLoanDto {
    @NotNull(message = "Id cannot be null")
    private Integer id;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 30, message = "First name must be 2–30 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 30, message = "Last name must be 2–30 characters")
    private String lastName;

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 120, message = "Age must be less than 120")
    private Integer age;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 5, max = 100, message = "Address must be 5–100 characters")
    private String address;

//    @NotNull(message = "Aadhar number cannot be null")
//    @Digits(integer = 12, fraction = 0, message = "Aadhar number must be 12 digits")

    @NotNull(message = "Aadhar number is required")
    @Min(value = 100000000000L, message = "Aadhar number must be 12 digits")
    @Max(value = 999999999999L, message = "Aadhar number must be 12 digits")
    private Long adharNo;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    private String country;
}
