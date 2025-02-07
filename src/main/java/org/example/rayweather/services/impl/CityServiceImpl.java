package org.example.rayweather.services.impl;

import lombok.AllArgsConstructor;
import org.example.rayweather.dto.CityDto;
import org.example.rayweather.entities.City;
import org.example.rayweather.exceptions.CityNotFoundException;
import org.example.rayweather.mappers.CityMapper;
import org.example.rayweather.repositories.CityRepository;
import org.example.rayweather.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;

    @Override
    public CityDto createCity(CityDto cityDto) {
        City city = CityMapper.mapToCity(cityDto);
        City savedCity = cityRepository.save(city);
        return CityMapper.mapToCityDto(savedCity);
    }

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

    @Override
    public CityDto updateCity(Long cityId, CityDto updateCity) {
        City city = cityRepository.findById(cityId).orElseThrow(
                () -> new CityNotFoundException("City is not exists with given id: " + cityId)
        );
        city.setPlace_id(updateCity.getPlace_id());
        city.setCity_name(updateCity.getCity_name());
        City updatedCityObj = cityRepository.save(city);

        return CityMapper.mapToCityDto(updatedCityObj);
    }

    @Override
    public void deleteCity(Long cityId) {
        City city = cityRepository.findById(cityId).orElseThrow(
                () -> new CityNotFoundException("City is not exists with given id: " + cityId)
        );
        cityRepository.deleteById(cityId);

    }


}
