package com.xworkz.module.service;

import com.xworkz.module.dto.XworkzDto;

public interface XworkzService {
    boolean validateAndSave(XworkzDto xworkzDto);

    XworkzDto findEmail(String emailOrPhone,String password);
}
