package org.example.rayweather.services.impl;

import org.example.springbootdemoversion.dto.CityDto;

import java.util.List;

public interface CityService {
    CityDto createCity(CityDto cityDto);
    CityDto getCityById(Long cityId);
    List<CityDto> getAllCities();

    CityDto updateCity(Long cityId, CityDto updateCity);

    void deleteCity(Long cityId);


}
