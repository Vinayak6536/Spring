package com.xworkz.module.service;

import com.xworkz.module.dto.XworkzDto;

public interface XworkzService {
    boolean validateAndSave(XworkzDto xworkzDto);

    String findEmail(String emailOrPhone,String password);

    int getCount(String emailOrPhoneNo);

    void updateCount(String emailOrPhone);

    void setCount(String emailOrPhone);

    boolean checkEmailOrPhone(String emailorPhone);

    boolean saveOtp(String emailOrPhone, int randaomOTP);
}
