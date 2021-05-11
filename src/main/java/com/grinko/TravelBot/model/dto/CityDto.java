package com.grinko.TravelBot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class CityDto {

    @Setter
    @Getter
    private UUID id;
    @Setter
    @Getter
    private String name;
}
