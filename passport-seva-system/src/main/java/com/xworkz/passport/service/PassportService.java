package com.xworkz.passport.service;

import com.xworkz.passport.dto.PassportDto;

public interface PassportService {

    boolean validateAndSave(PassportDto passportDto);
}
