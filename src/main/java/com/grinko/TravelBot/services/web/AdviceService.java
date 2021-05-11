package com.grinko.TravelBot.services.web;

import com.grinko.TravelBot.model.dto.AdviceDto;
import com.grinko.TravelBot.model.entity.Advice;
import com.grinko.TravelBot.model.mapper.AdviceMapper;
import com.grinko.TravelBot.repositories.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
public class AdviceService {

    @Autowired
    private AdviceRepository repository;
    @Autowired
    private CityService cityService;
    @Autowired
    private AdviceMapper mapper;

    public AdviceDto saveAdvice(AdviceDto advice){
        Advice newAdvice = repository.save(mapper.mapToAdvice(advice));
        return mapper.mapToAdviceDto(newAdvice);
    }

    public AdviceDto getAdviceById(UUID id){
        return mapper.mapToAdviceDto(repository.findById(id).get());
    }

    public List<AdviceDto> getAdvices(){
        List<AdviceDto> adviceDtoList = new LinkedList<>();
        repository.findAll().forEach(advice -> adviceDtoList.add(mapper.mapToAdviceDto(advice)));
        return adviceDtoList;
    }

    public void deleteAdvice(UUID id){
        repository.deleteById(id);
    }

    public AdviceDto editAdvice(AdviceDto advice){
        Advice newAdvice = repository.save(mapper.mapToAdvice(advice));
        return  mapper.mapToAdviceDto(newAdvice);
    }

    public String getAdviceByCityName(String name){
        return repository.findByCity(cityService.getCityByName(name)).getAdvice();
    }

}
