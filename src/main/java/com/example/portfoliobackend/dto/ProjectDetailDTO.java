package com.example.portfoliobackend.dto;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetailDTO {
    private Integer projectId;
    private String projectName;

    @Temporal(TemporalType.DATE)
    private Date dateCompleted;

    private String projectHeaderImage;
    private String projectType;

    //TODO finish this one
}