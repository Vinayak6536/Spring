package com.xworkz.zomato.service.impl;

import com.xworkz.zomato.dao.ZomatoDao;
import com.xworkz.zomato.dto.ZomatoDto;
import com.xworkz.zomato.service.ZomatoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Data
@Component
public class ZomatoServiceImpl implements ZomatoService {
    @Autowired
    private ZomatoDao zomatoDao;

    @Override
    public boolean validateAndSave(ZomatoDto zomatoDto) {
        boolean isValid=false;

        if (zomatoDto != null){
            isValid=true;
            return zomatoDao.save(zomatoDto);
        }
        else {
            System.out.println("Invalid Details");
        }

        return isValid;
    }

    @Override
    public Optional<ZomatoDto> getNameByPhoneNo(Long phoneNo) {

        if (phoneNo != null){
            Optional<ZomatoDto> zomatoDto1=zomatoDao.savePhone(phoneNo);

            return zomatoDto1;
        }


        return Optional.empty();
    }
}
