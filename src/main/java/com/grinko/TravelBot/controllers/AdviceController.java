package com.grinko.TravelBot.controllers;

import com.grinko.TravelBot.model.dto.AdviceDto;
import com.grinko.TravelBot.services.web.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/advice")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @GetMapping("/{id}")
    public AdviceDto getAdvice(@PathVariable UUID id){
        return adviceService.getAdviceById(id);
    }

    @GetMapping
    List<AdviceDto> getAll() {
        return adviceService.getAdvices();
    }

    @PostMapping
    AdviceDto newAdvice(@RequestBody AdviceDto newAdvice) {
        return adviceService.saveAdvice(newAdvice);
    }

    @PutMapping
    AdviceDto replaceAdvice(@RequestBody AdviceDto newAdvice) {

        return adviceService.editAdvice(newAdvice);
    }
    @DeleteMapping("/{id}")
    public void deleteAdvice(@PathVariable UUID id){
        adviceService.deleteAdvice(id);
    }

}
