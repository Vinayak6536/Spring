package com.xworkz.module.service.xworkz;

import com.xworkz.module.dto.XworkzDto;

public interface XworkzService {
    boolean validateAndSave(XworkzDto xworkzDto);

    XworkzDto findEmail(String emailOrPhone,String password);

    int getCount(String emailOrPhoneNo);

    void updateCount(String emailOrPhone);

    void setCount(String emailOrPhone);

    boolean checkEmailOrPhone(String emailorPhone);

    boolean saveOtp(String emailOrPhone, int randaomOTP);

    boolean verifyOtp(String emailOrPhone, int otp);

    boolean resetPassword(String emailOrPhone,String password,String confirmPassword);
}
