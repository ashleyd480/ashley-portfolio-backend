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
public class ProjectForListDTO {
    private Integer projectId;
    private String projectName;


    private String dateCompleted;

    private String projectHeaderImage;
    private String projectType;

    private List<SkillDTO> skills;

}
