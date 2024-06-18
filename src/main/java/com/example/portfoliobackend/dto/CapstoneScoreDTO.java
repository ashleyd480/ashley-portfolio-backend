package com.example.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapstoneScoreDTO {

    private String capstoneScoreCategory;

    private String capstoneCriteria;

    private BigDecimal capstonePossiblePoints;
    // used to handle Numeric decimal values in postgres

    private Integer capstoneActualPoints;

    private String capstoneCriteriaComments;
}
