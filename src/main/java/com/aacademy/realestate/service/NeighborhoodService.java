package com.aacademy.realestate.service;

import com.aacademy.realestate.model.Neighborhood;

import java.util.Set;

public interface NeighborhoodService {

    Neighborhood save(Neighborhood neighborhood);

    Neighborhood findById(Long id);

    Neighborhood findByName(String name);

    Set<Neighborhood> findAll();
}
