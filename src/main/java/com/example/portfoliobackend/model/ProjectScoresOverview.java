package com.example.portfoliobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project_score_overview")

public class ProjectScoresOverview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_score_id")
    private Integer projectScoreId;

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "short_desc", length = 500)
    private String shortDesc;

    @Column(name = "instructor_overall_comment", length = 1000)
    private String instructorOverallComment;

    @Column(name = "has_score")
    private Boolean hasScore;

}
