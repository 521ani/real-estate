package com.aacademy.realestate.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FloorDto {

    private Long id;

    @Range(min = -3, max = 164, message = "Floor must be between -3 and 164.")
    private Integer number;
}
