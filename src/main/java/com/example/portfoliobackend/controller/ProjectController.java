package com.example.portfoliobackend.controller;

import com.example.portfoliobackend.dto.ProjectDetailDTO;
import com.example.portfoliobackend.dto.ProjectForListDTO;
import com.example.portfoliobackend.dto.ResponseDTO;
import com.example.portfoliobackend.model.Project;
import com.example.portfoliobackend.service.ProjectService;
import com.example.portfoliobackend.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    ProjectService projectService;


    /* ------- RETRIEVE -------- */
    @GetMapping
    public ResponseEntity<?> getAllProjectResults() {
        List<ProjectForListDTO> allProjectResults = projectService.getAllProjectResults();
        return ResponseUtils.generateResponse(allProjectResults);
    }


    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectDetailById (@PathVariable Integer projectId) {
       ProjectDetailDTO projectDetail = projectService.getProjectDetailById(projectId);
        ResponseDTO responseDTO = ResponseDTO.builder()
                    .hasError(false)
                    .data(projectDetail)
                    .status(HttpStatus.OK)
                    .build();
        return ResponseEntity.ok(responseDTO);
        }
    }


