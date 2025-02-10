package org.example.rayweather.controllers;

import lombok.AllArgsConstructor;
import org.example.rayweather.dto.CityDto;
import org.example.rayweather.services.impl.CityServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cities")
public class CityController {
    private CityServiceImpl cityService;



    @GetMapping("{id}")
    public ResponseEntity<String> getCityById(@PathVariable("id") Long cityId){
        CityDto citydto = cityService.getCityById(cityId);
        return ResponseEntity.ok(citydto.getCity_name());
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities(){
        List<CityDto> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }
    @GetMapping("/update")
    public ResponseEntity<List<CityDto>> updateAllCities(){
        List<CityDto> cities = cityService.updateAllCities();
        return ResponseEntity.ok(cities);
    }




}
