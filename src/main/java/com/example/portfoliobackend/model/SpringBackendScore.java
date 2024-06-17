package com.example.portfoliobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "spring_backend_score")
@NoArgsConstructor
@AllArgsConstructor
public class SpringBackendScore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spring_backend_score_seq")
    @Column(name = "spring_backend_score_id")
    private Long id;

    @Column(name = "spring_backend_criteria", length = 100)
    private String criteria;

    @Column(name = "spring_backend_score")
    private Integer score;

}
