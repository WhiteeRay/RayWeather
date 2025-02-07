package org.example.rayweather.services.impl;

import lombok.AllArgsConstructor;
import org.example.rayweather.dto.CityDto;
import org.example.rayweather.entities.City;
import org.example.rayweather.exceptions.CityNotFoundException;
import org.example.rayweather.mappers.CityMapper;
import org.example.rayweather.repositories.CityRepository;
import org.example.rayweather.services.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;


    @Override
    public CityDto getCityById(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(()->
                        new CityNotFoundException("City is not exists with given id: " + cityId ));

        return CityMapper.mapToCityDto(city);
    }

    @Override
    public List<CityDto> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().map((city)-> CityMapper.mapToCityDto(city))
                .collect(Collectors.toList());
    }



}
