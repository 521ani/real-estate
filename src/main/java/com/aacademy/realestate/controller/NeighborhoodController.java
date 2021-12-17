package com.aacademy.realestate.controller;

import com.aacademy.realestate.converter.NeighborhoodConverter;
import com.aacademy.realestate.dto.NeighborhoodDto;
import com.aacademy.realestate.model.Neighborhood;
import com.aacademy.realestate.service.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/neighborhoods")
public class NeighborhoodController {

    private final NeighborhoodService neighborhoodService;
    private final NeighborhoodConverter neighborhoodConverter;

    @Autowired
    public NeighborhoodController(NeighborhoodService neighborhoodService, NeighborhoodConverter neighborhoodConverter) {
        this.neighborhoodService = neighborhoodService;
        this.neighborhoodConverter = neighborhoodConverter;
    }

    @GetMapping
    public ResponseEntity<Set<NeighborhoodDto>> findAll() {
        return ResponseEntity.ok(neighborhoodService.findAll()
                .stream()
                .map(neighborhoodConverter::toNeighborhoodDto)
                .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/name")
    public ResponseEntity<NeighborhoodDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(neighborhoodConverter.toNeighborhoodDto(neighborhoodService.findByName(name)));
    }

    @PostMapping
    public ResponseEntity<NeighborhoodDto> save(@RequestBody Neighborhood neighborhood) {
        return ResponseEntity.ok(neighborhoodConverter.toNeighborhoodDto(neighborhoodService.save(neighborhood)));
    }
}
