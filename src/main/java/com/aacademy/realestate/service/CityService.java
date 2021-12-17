package com.aacademy.realestate.service;

import com.aacademy.realestate.model.City;

import java.util.Set;

public interface CityService {

    City save(City city);

    City findById(Long id);

    Set<City> findAll();

    City update(Long id, City city);

    void detachNeighborhood(Long cityId, Set<Long> neighborhoodIds);
}
