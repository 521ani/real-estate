package com.aacademy.realestate.service;

import com.aacademy.realestate.model.Neighborhood;

import java.util.Set;

public interface NeighborhoodService {

    Neighborhood save(Neighborhood neighborhood);

    Neighborhood update(Long id, Neighborhood neighborhood);

    Neighborhood findByName(String name);

    Set<Neighborhood> findAll();

    Neighborhood findById(Long id);
}
