package com.xworkz.blood.service.impl;

import com.xworkz.blood.dao.BloodDao;
import com.xworkz.blood.dto.BloodDto;
import com.xworkz.blood.service.BloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class BloodServiceImpl implements BloodService {

    @Autowired
    private BloodDao bloodDao;
    @Override
    public boolean validateAndSave(BloodDto dto) {
        boolean valid = true;
        if (dto != null){
            // donorId (optional)
            if (dto.getDonorId() != null && dto.getDonorId().length() < 5) {
                System.out.println("Invalid Donor ID");
                valid = false;
            }

            // firstName
            if (dto.getFirstName() == null || dto.getFirstName().length() < 3
                    || dto.getFirstName().length() > 30) {
                System.out.println("Invalid First Name");
                valid = false;
            }

            // lastName
            if (dto.getLastName() == null || dto.getLastName().length() < 1
                    || dto.getLastName().length() > 30) {
                System.out.println("Invalid Last Name");
                valid = false;
            }

            // dob (yyyy-mm-dd)
            if (dto.getDob() == null || !dto.getDob().matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Invalid Date of Birth");
                valid = false;
            }

            // zipCode (India / US generic 5–6 digits)
            if (dto.getZipCode() < 10000 || dto.getZipCode() > 999999) {
                System.out.println("Invalid Zip Code");
                valid = false;
            }

            // email
            if (dto.getEmail() == null ||
                    !dto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                System.out.println("Invalid Email");
                valid = false;
            }

            // phone (10 digits)
            if (String.valueOf(dto.getPhone()).length() != 10) {
                System.out.println("Invalid Phone Number");
                valid = false;
            }

            // password
            if (dto.getPassword() == null || dto.getPassword().length() < 6) {
                System.out.println("Password must be at least 6 characters");
                valid = false;
            }

            // confirmPassword
            if (!dto.getPassword().equals(dto.getConfirmPassword())) {
                System.out.println("Password and Confirm Password do not match");
                valid = false;
            }

            if (valid) {
                System.out.println("Registration data is valid. Saving...");
                return bloodDao.save(dto);
            }


        }
        return valid;
    }

    @Override
    public List<BloodDto> findByFirstName(String firstName) {

        if (firstName == null || firstName.trim().length() < 3) {
            System.out.println("Invalid first name for search");
            return null;
        }
        else {
            List<BloodDto> fetch=bloodDao.findByFirstName(firstName);
            return fetch;
        }
    }

    @Override
    public boolean updateAndSave(BloodDto dto) {
        boolean valid = true;
        if (dto != null){
            // donorId (optional)
            if (dto.getDonorId() != null && dto.getDonorId().length() < 5) {
                System.out.println("Invalid Donor ID");
                valid = false;
            }

            // firstName
            if (dto.getFirstName() == null || dto.getFirstName().length() < 3
                    || dto.getFirstName().length() > 30) {
                System.out.println("Invalid First Name");
                valid = false;
            }

            // lastName
            if (dto.getLastName() == null || dto.getLastName().length() < 1
                    || dto.getLastName().length() > 30) {
                System.out.println("Invalid Last Name");
                valid = false;
            }

            // dob (yyyy-mm-dd)
            if (dto.getDob() == null || !dto.getDob().matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Invalid Date of Birth");
                valid = false;
            }

            // zipCode (India / US generic 5–6 digits)
            if (dto.getZipCode() < 10000 || dto.getZipCode() > 999999) {
                System.out.println("Invalid Zip Code");
                valid = false;
            }

            // email
            if (dto.getEmail() == null ||
                    !dto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                System.out.println("Invalid Email");
                valid = false;
            }

            // phone (10 digits)
            if (String.valueOf(dto.getPhone()).length() != 10) {
                System.out.println("Invalid Phone Number");
                valid = false;
            }


            if (valid) {
                System.out.println("Registration data is valid. Saving...");
                return bloodDao.updatedSave(dto);
            }


        }
        return valid;
    }

    @Override
    public boolean deleted(String firstName) {
        if (firstName == null || firstName.trim().length() < 3) {
            System.out.println("Invalid first name for search");
            return false;
        }
        else {
            boolean delete=bloodDao.deleted(firstName);
            return delete;
        }
    }
}
