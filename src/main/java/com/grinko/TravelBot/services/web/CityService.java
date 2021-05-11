package com.grinko.TravelBot.services.web;

import com.grinko.TravelBot.model.dto.CityDto;
import com.grinko.TravelBot.model.entity.City;
import com.grinko.TravelBot.model.mapper.CityMapper;
import com.grinko.TravelBot.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;
    @Autowired
    private CityMapper mapper;

    public boolean isExists(String cityName){
        return repository.existsCityByName(cityName);
    }

    public City getCityByName(String name){
        return repository.findByName(name);
    }

    public CityDto getCityById(UUID id) {
        return  mapper.mapToCityDto(repository.findById(id).get());
    }

    public List<CityDto> getCity() {
        List<CityDto> cityDtoList = new LinkedList<>();
        repository.findAll().forEach(city -> cityDtoList.add(mapper.mapToCityDto(city)));
        return cityDtoList;
    }

    public CityDto saveCity(CityDto city) {
        City newCity = repository.save(mapper.mapToCity(city));
        return mapper.mapToCityDto(newCity);
    }

    public CityDto editCity(CityDto city) {
        City newCity = repository.save(mapper.mapToCity(city));
        return mapper.mapToCityDto(newCity);
    }

    public void deleteCity(UUID id) {
        repository.deleteById(id);
    }
}
