package com.aacademy.realestate.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CityDto {

    private Long id;

    private String name;

    private Set<Long> neighborhoodIds;
}
