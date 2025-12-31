package com.xworkz.zomato.service.impl;

import com.xworkz.zomato.dao.ZomatoDao;
import com.xworkz.zomato.dto.ZomatoDto;
import com.xworkz.zomato.service.ZomatoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ZomatoServiceImpl implements ZomatoService {
    @Autowired
    private ZomatoDao zomatoDao;

    @Override
    public boolean validateAndSave(ZomatoDto zomatoDto) {
        boolean isValid = false;

        if (zomatoDto != null) {
            isValid = true;
            return zomatoDao.save(zomatoDto);
        } else {
            System.out.println("Invalid Details");
        }

        return isValid;
    }

    @Override
    public Optional<ZomatoDto> getNameByPhoneNo(Long phoneNo) {

        if (phoneNo != null) {
            Optional<ZomatoDto> zomatoDto1 = zomatoDao.savePhone(phoneNo);

            return zomatoDto1;
        }


        return Optional.empty();
    }

    @Override
    public Optional<ZomatoDto> getRestaurantName(String name) {

        if (name != null) {
            return zomatoDao.saveName(name);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public boolean updateAndSave(ZomatoDto zomatoDto) {
        boolean isValid = false;

        if (zomatoDto != null) {
            return zomatoDao.updated(zomatoDto);
        } else {
            System.out.println("Invalid Details");
        }

        return isValid;
    }

    @Override
    public boolean deleteAndSave(ZomatoDto zomatoDto) {
        boolean isValid = false;

        if (zomatoDto != null) {
            return zomatoDao.deleted(zomatoDto);
        } else {
            System.out.println("Invalid Details");
        }

        return isValid;
    }
}
