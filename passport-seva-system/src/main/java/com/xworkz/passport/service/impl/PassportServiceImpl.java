package com.xworkz.passport.service.impl;

import com.xworkz.passport.dao.PassportDao;
import com.xworkz.passport.dto.PassportDto;
import com.xworkz.passport.service.PassportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportDao passportDao;

    @Override
    public boolean validateAndSave(PassportDto passportDto) {
        boolean isValid=false;

        if (passportDto != null){
            if (passportDto.getFirstName().trim().isEmpty()){
                System.out.println("Enter valid FirstName");
                isValid=true;
            } else if (passportDto.getLastName().trim().isEmpty()){
                System.out.println("Enter valid LastName");
                isValid=true;
            } else if (passportDto.getAge() == 0 ) {
                System.out.println("Enter valid Age");
                isValid=true;
            } else if (passportDto.getDob()==null) {
                System.out.println("Enter Valid Date Of Birth");
                isValid=true;
            } else if (passportDto.getAdharNo() > 11  && passportDto.getAdharNo() < 13 ) {
                System.out.println("Enter valid Adhar Number");
                isValid=true;
            } else if (passportDto.getAddress().trim().isEmpty()) {
                System.out.println("Enter valid Address");
                isValid=true;
            }
            else {
                isValid=true;
                passportDao.save(passportDto);
            }
        }
        return isValid;
    }
}
