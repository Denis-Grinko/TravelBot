package com.grinko.TravelBot.repositories;

import com.grinko.TravelBot.model.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends CrudRepository<City, UUID> {

    boolean existsCityByName(String name);

    City findByName(String name);
}
