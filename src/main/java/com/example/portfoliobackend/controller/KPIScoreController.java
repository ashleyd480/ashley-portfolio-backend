package com.example.portfoliobackend.controller;

import com.example.portfoliobackend.dto.BootcampScoreDTO;
import com.example.portfoliobackend.dto.ProjectScoreOverviewDTO;
import com.example.portfoliobackend.dto.ResponseDTO;
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
    // Bootcamp Scores
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

}
