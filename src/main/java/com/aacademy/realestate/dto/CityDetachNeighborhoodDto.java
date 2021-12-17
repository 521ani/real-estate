package com.aacademy.realestate.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CityDetachNeighborhoodDto {

    private Long cityId;

    private Set<Long> neighborhoodIds;
}
