package com.example.portfoliobackend.controller;

import com.example.portfoliobackend.dto.ProjectDetailDTO;
import com.example.portfoliobackend.dto.ProjectForListDTO;
import com.example.portfoliobackend.dto.ResponseDTO;
import com.example.portfoliobackend.model.Project;
import com.example.portfoliobackend.service.ProjectService;
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

    //TODO since I have error handling already via global exception handler, do i still need to use this if/else here?


    /* ------- RETRIEVE -------- */
    @GetMapping
    public ResponseEntity<?> getAllProjectResults () {
        List<ProjectForListDTO> allProjectResults = projectService.getAllProjectResults();
        if (allProjectResults.isEmpty()) {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .hasError(true)
                    .error("There were no projects found")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .hasError(false)
                    .data(allProjectResults)
                    .status(HttpStatus.OK)
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        }
    }

//    @GetMapping("/{projectId}")
//    public ResponseEntity<?> getProjectDetailBId (@PathVariable Integer projectId) {
//        List<ProjectDetailDTO> projectDetail = projectService.getProjectDetailById(projectId);
//        ResponseDTO responseDTO = ResponseDTO.builder()
//                    .hasError(false)
//                    .data(projectDetail)
//                    .status(HttpStatus.OK)
//                    .build();
//            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//        }
    }


