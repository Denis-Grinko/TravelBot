package com.grinko.TravelBot.model.mapper;

import com.grinko.TravelBot.model.dto.CityDto;
import com.grinko.TravelBot.model.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public CityDto mapToCityDto( City city){
        return new CityDto(city.getId(), city.getName());
    }

    public City mapToCity( CityDto cityDto){
        return new City(cityDto.getId(), cityDto.getName());
    }

}
