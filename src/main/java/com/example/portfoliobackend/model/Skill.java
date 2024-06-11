package com.example.portfoliobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "skillname", unique = true, nullable = false)
    private String skillName;

    // Other fields...

    @ManyToMany(mappedBy = "skills")
    private List<Project> projects;

}
