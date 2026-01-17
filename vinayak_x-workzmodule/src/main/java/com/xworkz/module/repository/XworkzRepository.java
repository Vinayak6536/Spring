package com.xworkz.module.repository;

import com.xworkz.module.entity.XworkzEntity;

public interface XworkzRepository {
    boolean save(XworkzEntity xworkzEntity);

    XworkzEntity findEmail(String emailOrPhone);
}
