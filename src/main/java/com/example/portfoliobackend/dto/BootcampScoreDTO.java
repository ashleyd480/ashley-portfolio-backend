package com.example.portfoliobackend.dto;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootcampScoreDTO {
    private Integer week;

    @Temporal(TemporalType.DATE)
    private Date weekOf;

    private String topic;

    private String gaScore;

    private String gaComments;

    private String mentorScore;

    private String mentorComments;
}
