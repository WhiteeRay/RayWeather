package org.example.rayweather.services;

import org.example.rayweather.dto.CityDto;

import java.util.List;

public interface CityService {
    CityDto getCityById(Long cityId);
    List<CityDto> getAllCities();




}
