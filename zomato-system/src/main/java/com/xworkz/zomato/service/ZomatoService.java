package com.xworkz.zomato.service;

import com.xworkz.zomato.dto.ZomatoDto;

public interface ZomatoService {
    boolean validateAndSave(ZomatoDto zomatoDto);
}
