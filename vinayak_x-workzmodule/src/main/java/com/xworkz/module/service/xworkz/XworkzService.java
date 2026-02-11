package com.xworkz.module.service.xworkz;

import com.xworkz.module.dto.XworkzDto;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface XworkzService {
    boolean validateAndSave(XworkzDto xworkzDto) throws IOException;

    XworkzDto findEmail(String emailOrPhone,String password);

    int getCount(String emailOrPhoneNo);

    void updateCount(String emailOrPhone);

    void setCount(String emailOrPhone);

    boolean checkEmailOrPhone(String emailorPhone);

    boolean saveOtp(String emailOrPhone, int randaomOTP);

    boolean verifyOtp(String emailOrPhone, int otp);

    boolean resetPassword(String emailOrPhone,String password,String confirmPassword);

    XworkzDto viewProfileByEmail(String email) throws IOException;

    boolean updateAdminProfile(XworkzDto xworkzDto) throws IOException;
}
