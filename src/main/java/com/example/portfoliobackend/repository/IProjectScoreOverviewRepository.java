package com.example.portfoliobackend.repository;

import com.example.portfoliobackend.dto.ProjectScoreOverviewDTO;
import com.example.portfoliobackend.model.ProjectScoreOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProjectScoreOverviewRepository extends JpaRepository <ProjectScoreOverview, Integer> {

//    @Query("SELECT new com.example.portfoliobackend.dto.ProjectScoreOverviewDTO(pso.shortDesc, pso.instructorOverallComment, pso.hasScore, " +
//            "p.projectId, p.projectName, p.dateCompleted, p.projectURL) " +
//            "FROM ProjectScoreOverview pso " +
//            "JOIN pso.project p")
//    Optional <List<ProjectScoreOverviewDTO>> findProjectScoreOverviewWithDetails ();

//TODO not too sure if this method better; did not see instructor showing it this way in class so reverting to for each loop
}
