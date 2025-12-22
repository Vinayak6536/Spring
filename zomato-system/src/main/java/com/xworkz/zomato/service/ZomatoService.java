package com.xworkz.zomato.service;

import com.xworkz.zomato.dto.ZomatoDto;

import java.util.Optional;

public interface ZomatoService {
    boolean validateAndSave(ZomatoDto zomatoDto);

    Optional<ZomatoDto> getNameByPhoneNo(Long  phoneNo);
}
