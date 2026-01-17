package com.xworkz.module.service.impl;

import com.xworkz.module.crypt.PasswordCipherUtil;
import com.xworkz.module.dto.XworkzDto;
import com.xworkz.module.entity.XworkzEntity;
import com.xworkz.module.repository.XworkzRepository;
import com.xworkz.module.service.XworkzService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class XworkzServiceImpl implements XworkzService {

    @Autowired
    private XworkzRepository xworkzRepository;

    @Autowired
    private XworkzEntity xworkzEntity;

    @Autowired
    private PasswordCipherUtil passwordCipherUtil;



    private static final String SECRET_KEY = "MySecretKey12345";

    @Override
    public boolean validateAndSave(XworkzDto xworkzDto) {
        if (xworkzDto != null){

            PasswordCipherUtil util = new PasswordCipherUtil();
            String encryptedPassword = util.encrypt(xworkzDto.getPassword());
            BeanUtils.copyProperties(xworkzDto,xworkzEntity);
            xworkzEntity.setPassword(encryptedPassword);
            System.out.println(xworkzEntity);
            return xworkzRepository.save(xworkzEntity);


        }
        return false;
    }

    @Override
    public XworkzDto findEmail(String emailOrPhone, String password) {
        if (emailOrPhone != null){
            System.out.println(emailOrPhone);
            System.out.println(password);
           XworkzEntity xworkzEntity= xworkzRepository.findEmail(emailOrPhone);
            System.out.println(xworkzEntity);
            XworkzDto xworkzDto=new XworkzDto();
            BeanUtils.copyProperties(xworkzEntity,xworkzDto);
           String util=passwordCipherUtil.decrypt(xworkzDto.getPassword());
            System.out.println(xworkzDto);
            System.out.println(util);
           if (util.equals(password)){
               System.out.println(xworkzDto);
                return xworkzDto;
           }
           else {
               System.out.println("Invalid Password");
           }
        }
        return null;
    }
}
