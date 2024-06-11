package com.example.portfoliobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "bootcamp_scores")
@NoArgsConstructor
@AllArgsConstructor
public class BootcampScore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "bootcampscore_id")
    private Integer bootcampScoreId;

    private Integer week;

    @Column(name = "week_of")
    @Temporal(TemporalType.DATE)
    private Date weekOf;

    private String topic;

    @Column(name = "ga_score")
    private String gaScore;

    @Column(name = "ga_comments", length = 1000)
    private String gaComments;

    @Column(name = "mentor_score") // setting this as string to account for the -- symbol I use for null-value weeks
    private String mentorScore;

    @Column(name = "mentor_comments", length = 1000)
    private String mentorComments;
}
