package com.example.portfoliobackend.controller;

import com.example.portfoliobackend.dto.*;
import com.example.portfoliobackend.service.KPIScoreService;
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
    public ResponseEntity<?> getBootcampScoreList () {
        List<BootcampScoreDTO> bootcampScoreDTOList= kpiScoreService.getBootcampScoreList();
        ResponseDTO responseDTO = ResponseDTO.builder().hasError(false).data(bootcampScoreDTOList).status(HttpStatus.OK).build();
        return ResponseEntity.ok(responseDTO);

    }

    // Project Score Overview
    @GetMapping("project-score-overview")
    public ResponseEntity<?> getProjectScoreOverview () {
        List<ProjectScoreOverviewDTO> projectScoreOverviewDTOList = kpiScoreService.getProjectScoreOverview();
        ResponseDTO responseDTO = ResponseDTO.builder().hasError(false).data(projectScoreOverviewDTOList).status(HttpStatus.OK).build();
        return ResponseEntity.ok(responseDTO);

    }

    // Capstone Score
    @GetMapping("capstone-score")
    public ResponseEntity<?> getCapstoneScore () {
        List <CapstoneScoreDTO> capstoneScoreDTOList = kpiScoreService.getCapstoneScore();
        ResponseDTO responseDTO = ResponseDTO.builder().hasError(false).data(capstoneScoreDTOList).status(HttpStatus.OK).build();
        return ResponseEntity.ok(responseDTO);
    }

    // League App Score
    @GetMapping("league-app-score")
    public ResponseEntity<?>  getLeagueAppScore () {
        List <LeagueAppScoreDTO> leagueAppScoreDTOList = kpiScoreService.getLeagueAppScore();
        ResponseDTO responseDTO = ResponseDTO.builder().hasError(false).data(leagueAppScoreDTOList).status(HttpStatus.OK).build();
        return ResponseEntity.ok(responseDTO);

    }

    // Spring Backend Score
    @GetMapping("spring-backend-score")
    public ResponseEntity<?>  getSpringBackendScore () {
        List <SpringBackendScoreDTO> springBackendScoreDTOList = kpiScoreService.getSpringBackendScore();
        ResponseDTO responseDTO = ResponseDTO.builder().hasError(false).data(springBackendScoreDTOList).status(HttpStatus.OK).build();
        return ResponseEntity.ok(responseDTO);

    }

}
