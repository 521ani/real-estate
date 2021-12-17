package com.aacademy.realestate.controller;

import com.aacademy.realestate.converter.FloorConverter;
import com.aacademy.realestate.dto.FloorDto;
import com.aacademy.realestate.model.Floor;
import com.aacademy.realestate.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/floors")
public class FloorController {

    private final FloorService floorService;
    private final FloorConverter floorConverter;

    @Autowired
    public FloorController(FloorService floorService, FloorConverter floorConverter) {
        this.floorService =  floorService;
        this.floorConverter = floorConverter;
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<FloorDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(floorConverter.toFloorDto(floorService.findById(id)));
    }

    @GetMapping(value = "/number/{number}")
    public ResponseEntity<FloorDto> findByNumber(@PathVariable Integer number) {
        return ResponseEntity.ok(floorConverter.toFloorDto(floorService.findByNumber(number)));
    }

    @GetMapping
    public ResponseEntity<Set<FloorDto>> findAll(){
        return ResponseEntity.ok(floorService.findAll()
                .stream()
                .map(floorConverter::toFloorDto)
                .collect(Collectors.toSet()));
    }
    @PostMapping
    public ResponseEntity<FloorDto> save(@RequestBody @Valid FloorDto floorDto) {
        Floor floor = floorConverter.toFloor(floorDto);
        Floor savedFloor = floorService.save(floor);

        return ResponseEntity.ok(floorConverter.toFloorDto(savedFloor));
    }

    @PutMapping
    public ResponseEntity<FloorDto> update(@RequestBody @Valid FloorDto floorDto,
                                           @PathVariable Long id) {
        Floor floor =  floorConverter.toFloor(floorDto);
        Floor updatedFloor =  floorService.update(id, floor);
        return ResponseEntity.ok(floorConverter.toFloorDto(updatedFloor));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(Long id) {
        floorService.delete(id);
        return ResponseEntity.ok().build();
    }

}
