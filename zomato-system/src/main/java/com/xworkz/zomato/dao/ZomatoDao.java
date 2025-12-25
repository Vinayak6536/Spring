package com.xworkz.zomato.dao;

import com.xworkz.zomato.dto.ZomatoDto;

import java.util.Optional;

public interface ZomatoDao {
    boolean save(ZomatoDto zomatoDto);

    boolean updated(ZomatoDto zomatoDto);

    Optional<ZomatoDto> savePhone(Long phoneNo);

    Optional<ZomatoDto> saveName(String name);
}
