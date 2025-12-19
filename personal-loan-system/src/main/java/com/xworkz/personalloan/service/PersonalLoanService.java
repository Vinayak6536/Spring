package com.xworkz.personalloan.service;

import com.xworkz.personalloan.dto.PersonalLoanDto;

public interface PersonalLoanService {
    boolean validateAndSave(PersonalLoanDto personalLoanDto);
}
