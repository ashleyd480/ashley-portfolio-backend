package com.example.portfoliobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "capstone_score")
@NoArgsConstructor
@AllArgsConstructor
public class CapstoneScore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "capstone_score_id")
    private Integer capstoneScoreId;

    @Column(name = "capstone_score_category", length = 100)
    private String capstoneScoreCategory;

    @Column(name = "capstone_criteria", length = 100)
    private String capstoneCriteria;

    @Column(name = "capstone_possible_points")
    private Integer capstonePossiblePoints;

    @Column(name = "capstone_actual_points")
    private Integer capstoneActualPoints;

    @Column(name = "capstone_criteria_comments", length= 500)
    private String capstoneCriteriaComments;

}
