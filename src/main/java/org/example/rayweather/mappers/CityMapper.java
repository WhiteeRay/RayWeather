package org.example.rayweather.mappers;
import org.example.rayweather.dto.CityDto;
import org.example.rayweather.entities.City;

public class CityMapper {
    public static CityDto mapToCityDto(City city){
        return new CityDto(
                city.getId(),
                city.getPlace_id(),
                city.getCity_name()
        );
    }
    public static City mapToCity(CityDto cityDto){
        return new City(
                cityDto.getId(),
                cityDto.getPlace_id(),
                cityDto.getCity_name()
        );
    }
}
