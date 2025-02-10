package org.example.rayweather.services.impl;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.rayweather.dto.CityDto;
import org.example.rayweather.entities.City;
import org.example.rayweather.exceptions.CityNotFoundException;
import org.example.rayweather.mappers.CityMapper;
import org.example.rayweather.repositories.CityRepository;
import org.example.rayweather.services.CityService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @SneakyThrows
    @Override
    @Cacheable(value="cityCache")
    public List<CityDto> getAllCities() {
        Thread.sleep(2000);
        List<City> cities = cityRepository.findAll();
        return cities.stream().map((city)-> CityMapper.mapToCityDto(city))
                .collect(Collectors.toList());
    }

    @CachePut(value="cityCache")
    public List<CityDto> updateAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().map((city)-> CityMapper.mapToCityDto(city))
                .collect(Collectors.toList());
    }




}
