package com.xworkz.module.service.xworkz.impl;

import com.xworkz.module.util.OTPUtil;
import com.xworkz.module.util.PasswordCipherUtil;
import com.xworkz.module.dto.XworkzDto;
import com.xworkz.module.entity.XworkzEntity;
import com.xworkz.module.repository.xworkz.XworkzRepository;
import com.xworkz.module.service.xworkz.XworkzService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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
    public boolean validateAndSave(XworkzDto xworkzDto) throws IOException {
      //  System.out.println("service"+xworkzDto);
        if (xworkzDto != null) {
            PasswordCipherUtil util = new PasswordCipherUtil();
            String encryptedPassword = util.encrypt(xworkzDto.getPassword());
            BeanUtils.copyProperties(xworkzDto, xworkzEntity);
            xworkzEntity.setPassword(encryptedPassword);
          //  System.out.println(xworkzEntity);

            MultipartFile multipartFile=xworkzDto.getFile();

            String uploadDir = "V:/Spring/GitBash/Spring/vinayak_x-workzmodule/UploadedImages/";

            String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();

            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, multipartFile.getBytes());

            xworkzEntity.setOriginalFileName(multipartFile.getOriginalFilename());
            xworkzEntity.setFileSize(multipartFile.getSize());
            xworkzEntity.setPath(fileName);
            return xworkzRepository.save(xworkzEntity);

        }
        return false;
    }

    @Override
    public XworkzDto findEmail(String emailOrPhone, String password) {
        if (emailOrPhone != null) {
                XworkzEntity fetchedPassword = xworkzRepository.findEmail(emailOrPhone);
                XworkzDto xworkzDto=new XworkzDto();
                BeanUtils.copyProperties(fetchedPassword,xworkzDto);
                String decryptPassword = passwordCipherUtil.decrypt(xworkzDto.getPassword());
             //   System.out.println(decryptPassword);
                if (decryptPassword.equals(password)) {
                    return xworkzDto;
                } else {
                    System.out.println("Invalid Password");
                    return null;
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

    @Override
    public XworkzDto viewProfileByEmail(String email) throws IOException{
        if (email != null){
           XworkzEntity xworkzEntity1= xworkzRepository.viewProfileByEmail(email);
           XworkzDto xworkzDto=new XworkzDto();
           BeanUtils.copyProperties(xworkzEntity1,xworkzDto);
           return xworkzDto;
        }
        return null;
    }

    @Override
    public boolean updateAdminProfile(XworkzDto xworkzDto) throws IOException {
        if (xworkzDto != null) {

            XworkzEntity oldEntity=xworkzRepository.findEmail(xworkzDto.getEmail());
            BeanUtils.copyProperties(xworkzDto, xworkzEntity);
            MultipartFile multipartFile = xworkzDto.getFile();

            if (multipartFile != null && !multipartFile.isEmpty()) {

                String uploadDir = "V:/Spring/GitBash/Spring/vinayak_x-workzmodule/UploadedImages/";

                String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();

                Path path = Paths.get(uploadDir + fileName);
                Files.write(path, multipartFile.getBytes());

                xworkzEntity.setOriginalFileName(multipartFile.getOriginalFilename());
                xworkzEntity.setFileSize(multipartFile.getSize());
                xworkzEntity.setPath(fileName);

            } else {
                // ✅ KEEP OLD IMAGE
                xworkzEntity.setOriginalFileName(oldEntity.getOriginalFileName());
                xworkzEntity.setFileSize(oldEntity.getFileSize());
                xworkzEntity.setPath(oldEntity.getPath());
            }
            xworkzRepository.updateAdminProfile(xworkzEntity);

            return true;
        }
        return false;
    }
}
