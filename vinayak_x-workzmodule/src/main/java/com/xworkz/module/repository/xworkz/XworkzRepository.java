package com.xworkz.module.repository.xworkz;

import com.xworkz.module.entity.XworkzEntity;

public interface XworkzRepository {
    boolean save(XworkzEntity xworkzEntity);

    XworkzEntity findEmail(String emailOrPhone);

    int getCount(String emailOrPhoneNo);

    void updateCount(String emailOrPhone);

    void setCount(String emailOrPhone);

    boolean checkEmailOrPhone(String emailorPhone);

    boolean saveOtp(String emailOrPhone, int randaomOTP);

    int verifyOtp(String emailOrPhone);

    void clearExpiredOtp();

    boolean resetPassword(String emailOrPhone, String encrypt);
}
