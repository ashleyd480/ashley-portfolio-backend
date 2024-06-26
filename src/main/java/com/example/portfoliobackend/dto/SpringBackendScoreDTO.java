package com.example.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpringBackendScoreDTO {
    private String springBackendCriteria;
    private String springBackendScore; // as this includes numbers/comments

}
