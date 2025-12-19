package com.xworkz.personalloan.service.impl;

import com.xworkz.personalloan.dao.PersonalLoanDao;
import com.xworkz.personalloan.dto.PersonalLoanDto;
import com.xworkz.personalloan.service.PersonalLoanService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonalLoanServiceImpl implements PersonalLoanService {
    @Autowired
    private PersonalLoanDao personalLoanDao;
    
    @Override
    public boolean validateAndSave(PersonalLoanDto personalLoanDto) {
        boolean isValid=false;
        if (personalLoanDto != null){
         if (personalLoanDto.getName().trim().isEmpty()){
             System.out.println("Enter Valid Name");
             isValid=true;
         } else if (personalLoanDto.getSurName().trim().isEmpty()) {
             System.out.println("Enter Valid Surname");
             isValid=true;
         } else if (personalLoanDto.getGender() == 0) {
             System.out.println("Enter valid gender");
             isValid=true;
         } else if (personalLoanDto.getDob().trim().isEmpty()) {
             System.out.println("Enter Valid Dob Format 'dd-mm-yyyy'");
             isValid=true;
         } else if (personalLoanDto.getAdharNO() == 0) {
             System.out.println("Enter valid adharNo");
             isValid=true;
         } else if (personalLoanDto.getPhoneNo() == 0) {
             System.out.println("Enter valid PhoneNo");
             isValid=true;
         }else if (personalLoanDto.getEmail().trim().isEmpty()){
             System.out.println("Enter valid Email");
             isValid=true;
         }else if (personalLoanDto.getMaritalStatus().trim().isEmpty()){
             System.out.println("Enter valid Marital Status");
             isValid=true;
         } else if (personalLoanDto.getAddress().trim().isEmpty()) {
             System.out.println("Enter valid Address");
             isValid=true;
         }else {
             isValid=true;
             personalLoanDao.save(personalLoanDto);

         }
        }        
        
        return isValid;
    }
}
