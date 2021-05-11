package com.grinko.TravelBot.repositories;

import com.grinko.TravelBot.model.entity.Advice;
import com.grinko.TravelBot.model.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdviceRepository extends CrudRepository<Advice, UUID> {

    Advice findByCity(City city);
}
