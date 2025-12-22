package com.xworkz.zomato.dao;

import com.xworkz.zomato.dto.ZomatoDto;

import java.util.Optional;

public interface ZomatoDao {
    boolean save(ZomatoDto zomatoDto);

    Optional<ZomatoDto> savePhone(Long phoneNo);
}
