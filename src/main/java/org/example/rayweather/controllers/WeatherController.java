package org.example.rayweather.controllers;

import org.example.rayweather.dto.CityDto;
import org.example.rayweather.entities.Weather;
import org.example.rayweather.services.impl.CityServiceImpl;
import org.example.rayweather.services.impl.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weathers")
public class WeatherController {
    private final WeatherServiceImpl weatherService;
    private CityServiceImpl cityService;
    @Autowired
    public WeatherController(WeatherServiceImpl weatherService, CityServiceImpl cityService) {
        this.weatherService = weatherService;
        this.cityService = cityService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<List<Weather>> getWeathers(@PathVariable("id") Long id) {
        CityDto cityDto = cityService.getCityById(id);
        String place_id = cityDto.getPlace_id();
        if (place_id.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<Weather> weathers = weatherService.getWeathers(place_id);

        return ResponseEntity.ok(weathers);
    }
}
