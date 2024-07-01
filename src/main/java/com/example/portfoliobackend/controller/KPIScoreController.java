package com.example.portfoliobackend.controller;

import com.example.portfoliobackend.dto.*;
import com.example.portfoliobackend.service.KPIScoreService;
import com.example.portfoliobackend.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scores")
@CrossOrigin(origins = "*")
public class KPIScoreController {
    @Autowired
    KPIScoreService kpiScoreService;

    /* ------- RETRIEVE -------- */
    // GA + mentor scores
    @GetMapping("bootcamp")
    public ResponseEntity<?> getBootcampScoreList() {
        List<BootcampScoreDTO> bootcampScoreDTOList = kpiScoreService.getBootcampScoreList();
        return ResponseUtils.generateResponse(bootcampScoreDTOList);
    }

    // Project Score Overview
    @GetMapping("project-score-overview")
    public ResponseEntity<?> getProjectScoreOverview() {
        List<ProjectScoreOverviewDTO> projectScoreOverviewDTOList = kpiScoreService.getProjectScoreOverview();
        return ResponseUtils.generateResponse(projectScoreOverviewDTOList);
    }

    // Capstone Score
    @GetMapping("capstone-score")
    public ResponseEntity<?> getCapstoneScore() {
        List<CapstoneScoreDTO> capstoneScoreDTOList = kpiScoreService.getCapstoneScore();
        return ResponseUtils.generateResponse(capstoneScoreDTOList);
    }

    // League App Score
    @GetMapping("league-app-score")
    public ResponseEntity<?> getLeagueAppScore() {
        List<LeagueAppScoreDTO> leagueAppScoreDTOList = kpiScoreService.getLeagueAppScore();
        return ResponseUtils.generateResponse(leagueAppScoreDTOList);
    }


    // Spring Backend Score
    @GetMapping("spring-backend-score")
    public ResponseEntity<?> getSpringBackendScore() {
        List<SpringBackendScoreDTO> springBackendScoreDTOList = kpiScoreService.getSpringBackendScore();
        return ResponseUtils.generateResponse(springBackendScoreDTOList);
    }

}
