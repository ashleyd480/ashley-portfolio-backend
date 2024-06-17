package com.example.portfoliobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "league_app_score")
@NoArgsConstructor
@AllArgsConstructor
public class LeagueAppScore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "league_app_score_id")
    private Integer leagueAppScoreId;

    @Column(name = "league_app_criteria", length = 100)
    private String leagueAppCriteria;

    @Column(name = "league_app_feedback", length = 500)
    private String leagueAppFeedback;

}
