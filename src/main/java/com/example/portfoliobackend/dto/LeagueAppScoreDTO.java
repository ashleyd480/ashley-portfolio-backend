package com.example.portfoliobackend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeagueAppScoreDTO {

    private String leagueAppCriteria;

    private String leagueAppFeedback;

}
