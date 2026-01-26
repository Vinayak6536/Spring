package com.xworkz.module.service.impl;

import com.xworkz.module.util.OTPUtil;
import com.xworkz.module.util.PasswordCipherUtil;
import com.xworkz.module.dto.XworkzDto;
import com.xworkz.module.entity.XworkzEntity;
import com.xworkz.module.repository.XworkzRepository;
import com.xworkz.module.service.XworkzService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class XworkzServiceImpl implements XworkzService {

    @Autowired
    private XworkzRepository xworkzRepository;

    @Autowired
    private XworkzEntity xworkzEntity;

    @Autowired
    private PasswordCipherUtil passwordCipherUtil;

    @Autowired
    private OTPUtil otpUtil;

    private static final String SECRET_KEY = "MySecretKey12345";

    @Override
    public boolean checkEmailOrPhone(String emailorPhone) {
        return xworkzRepository.checkEmailOrPhone(emailorPhone);
    }

    @Override
    public boolean validateAndSave(XworkzDto xworkzDto) {
      //  System.out.println("service"+xworkzDto);
        if (xworkzDto != null) {
            PasswordCipherUtil util = new PasswordCipherUtil();
            String encryptedPassword = util.encrypt(xworkzDto.getPassword());
            BeanUtils.copyProperties(xworkzDto, xworkzEntity);
            xworkzEntity.setPassword(encryptedPassword);
            System.out.println(xworkzEntity);
            return xworkzRepository.save(xworkzEntity);


        }
        return false;
    }

    @Override
    public String findEmail(String emailOrPhone, String password) {
        if (emailOrPhone != null) {

            String fetchedPassword = xworkzRepository.findEmail(emailOrPhone);
            String decryptPassword = passwordCipherUtil.decrypt(fetchedPassword);
            if (decryptPassword.equals(password)) {
                return fetchedPassword;
            } else {
                System.out.println("Invalid Password");
            }
        }
        return null;
    }

    @Override
    public int getCount(String emailOrPhoneNo) {
        return xworkzRepository.getCount(emailOrPhoneNo);
    }

    @Override
    public void updateCount(String emailOrPhone) {
        xworkzRepository.updateCount(emailOrPhone);
    }

    @Override
    public void setCount(String emailOrPhone) {
        xworkzRepository.setCount(emailOrPhone);
    }

    @Override
    public boolean saveOtp(String emailOrPhone, int randaomOTP) {
        xworkzRepository.clearExpiredOtp();
        if (randaomOTP != 0){
            String subject = "OTP Details";
            String text = "Your OTP for Verification Is: " + randaomOTP;
            otpUtil.sendSimpleMessage(emailOrPhone, text, subject);

            return xworkzRepository.saveOtp(emailOrPhone,randaomOTP);
        }
        return false;
    }

    @Override
    public boolean verifyOtp(String emailOrPhone, int otp) {
        xworkzRepository.clearExpiredOtp();
     //   System.out.println(emailOrPhone);
    //    System.out.println(otp);
        if (emailOrPhone != null){
            int verifyOtp=xworkzRepository.verifyOtp(emailOrPhone);
            System.out.println(verifyOtp);
            if (verifyOtp == otp){
                return true;
            }else {
                System.out.println("Password Incorrect");
            }
        }
        return false;
    }

    @Override
    public boolean resetPassword(String emailOrPhone, String password, String confirmPassword) {
        if (password.equals(confirmPassword)){

            String encrypt= passwordCipherUtil.encrypt(password);
           return xworkzRepository.resetPassword(emailOrPhone,encrypt);
        }
        return false;
    }
}
