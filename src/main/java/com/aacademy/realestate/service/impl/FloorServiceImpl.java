package com.aacademy.realestate.service.impl;

import com.aacademy.realestate.exception.ResourceNotFoundException;
import com.aacademy.realestate.exception.duplicateRecordsEcxeption;
import com.aacademy.realestate.model.Floor;
import com.aacademy.realestate.repository.FloorRepository;
import com.aacademy.realestate.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class FloorServiceImpl implements FloorService {

    private final FloorRepository floorRepository;

    @Autowired
    public FloorServiceImpl(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    @Override
    public Floor update(Long id, Floor floor) {
        Floor foundFloor = this.findById(id);
        Floor updatedFloor = Floor.builder()
                .id(foundFloor.getId())
                .number(floor.getNumber())
                .build();

        return save(updatedFloor);
    }

    @Override
    public Floor save(Floor floor) {
        try {
            return floorRepository.save(floor);
        } catch (DataIntegrityViolationException exception) {
            throw new duplicateRecordsEcxeption(String.format("Floor with number %d already exists.", floor.getNumber()))
        }
    }

    @Override
    public Floor findByNumber(Integer number) {
        return floorRepository.findByNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Floor with id %d does not exist.", number)));
    }

    @Override
    public Set<Floor> findAll() {
        Set<Floor> floors = new TreeSet<>(Comparator.comparing(Floor::getId));
        floors.addAll(floorRepository.findAll());

        return floors;
    }

    @Override
    public Floor findById(Long id) {
        return floorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Floor with number %d does not exist", id)));
    }

    @Override
    public void delete(Long id) {
        floorRepository.delete(this.findById(id));
    }
}
