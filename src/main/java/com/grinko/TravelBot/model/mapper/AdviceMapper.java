package com.grinko.TravelBot.model.mapper;

import com.grinko.TravelBot.model.dto.AdviceDto;
import com.grinko.TravelBot.model.entity.Advice;
import com.grinko.TravelBot.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceMapper {

    @Autowired
    private CityRepository cityRepository;

    public AdviceDto mapToAdviceDto(Advice advice){
        return new AdviceDto(advice.getId(), advice.getAdvice(), advice.getCity().getName(), advice.getCity().getId());
    }

    public Advice mapToAdvice(AdviceDto adviceDto){
        return new Advice(adviceDto.getId(), cityRepository.findById(adviceDto.getCityId()).get(), adviceDto.getAdvice());
    }
}
