package com.xworkz.passport.dao;

import com.xworkz.passport.dto.PassportDto;

public interface PassportDao {
    boolean save(PassportDto passportDto);
}
