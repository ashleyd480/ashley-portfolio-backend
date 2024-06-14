package com.example.portfoliobackend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectScoreOverviewDTO {
    private Integer projectId;
    private String projectName;

    @Temporal(TemporalType.DATE)
    private Date dateCompleted;

    private String projectURL;

    private String shortDesc;

    private String instructorOverallComment;

    private Boolean hasScore;


//    public ProjectScoreOverviewDTO(String shortDesc, String instructorOverallComment, Boolean hasScore, Integer projectId, String projectName, Date dateCompleted, String projectURL) {
//        this.shortDesc = shortDesc;
//        this.instructorOverallComment = instructorOverallComment;
//        this.hasScore = hasScore;
//        this.projectId = projectId;
//        this.projectName = projectName;
//        this.dateCompleted = dateCompleted;
//        this.projectURL = projectURL;
//    }
}
