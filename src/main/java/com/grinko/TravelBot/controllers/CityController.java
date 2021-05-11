package com.grinko.TravelBot.controllers;

import com.grinko.TravelBot.model.dto.CityDto;
import com.grinko.TravelBot.model.mapper.CityMapper;
import com.grinko.TravelBot.repositories.CityRepository;
import com.grinko.TravelBot.services.web.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{id}")
    public CityDto getAdvice(@PathVariable UUID id){
        return cityService.getCityById(id);
    }

    @GetMapping
    List<CityDto> getAll() {
        return cityService.getCity();
    }

    @PostMapping
    CityDto newAdvice(@RequestBody CityDto newCity) {
        return cityService.saveCity(newCity);
    }

    @PutMapping
    CityDto replaceAdvice(@RequestBody CityDto newCity) {

        return cityService.editCity(newCity);
    }
    @DeleteMapping("/{id}")
    public void deleteAdvice(@PathVariable UUID id){
        cityService.deleteCity(id);
    }

}
