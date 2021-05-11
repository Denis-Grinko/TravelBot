package com.grinko.TravelBot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class AdviceDto {

    @Setter
    @Getter
    private UUID id;
    @Setter
    @Getter
    private String advice;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private UUID cityId;
}
