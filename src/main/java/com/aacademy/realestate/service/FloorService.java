package com.aacademy.realestate.service;

import com.aacademy.realestate.model.Floor;

import java.util.Set;

public interface FloorService {

    Floor save(Floor floor);

    Floor update(Long id, Floor floor);

    Floor findByNumber(Integer number);

    Set<Floor> findAll();

    Floor findById(Long id);

    void delete(Long id);
}
