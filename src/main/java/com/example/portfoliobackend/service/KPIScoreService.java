package com.example.portfoliobackend.service;

import com.example.portfoliobackend.dto.*;
import com.example.portfoliobackend.model.*;
import com.example.portfoliobackend.repository.*;
import com.example.portfoliobackend.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KPIScoreService {

    // to map entity to DTO - as we require DTO to transfer data to frontend as best practice
    @Autowired
    ModelMapperUtil modelMapperUtil;

    @Autowired
    IProjectScoreOverviewRepository iProjectScoreOverviewRepository;

    //repositories for my project scores
    /* had to make separate dbs due to distinct data structure and column headers*/
    @Autowired
    IBootcampScoreRepository iBootcampScoreRepository;

    @Autowired
    ICapstoneScoreRepository iCapstoneScoreRepository;

    @Autowired
    ILeagueAppScoreRepository iLeagueAppScoreRepository;

    @Autowired
    ISpringBackendScoreRepository iSpringBackendScoreRepository;


    /* ------- RETRIEVE -------- */

    // GA + mentor scores
    public List<BootcampScoreDTO> getBootcampScoreList() {
        try {
            List<BootcampScore> bootcampScoreList = iBootcampScoreRepository.findAll();
            List<BootcampScoreDTO> bootcampScoreDTOList = new ArrayList<>();
            for (BootcampScore bootcampScore : bootcampScoreList) {
                bootcampScoreDTOList.add(modelMapperUtil.map(bootcampScore, BootcampScoreDTO.class));

            }
            return bootcampScoreDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching bootcamp score list: " + e.getMessage());
        }
    }

//    public List<ProjectScoreOverviewDTO> getProjectScoreOverview2() {
//        try {
//            return iProjectScoreOverviewRepository.findProjectScoreOverviewWithDetails().orElseThrow(() -> new RuntimeException("Unable to fetch list for project score overview"));
//        } catch (Exception e) {
//            throw new RuntimeException("Error fetching project score overview list: " + e.getMessage());
//        }
//    }


    // Project Score Overview
    public List<ProjectScoreOverviewDTO> getProjectScoreOverview() {
        try {
            List<ProjectScoreOverview> projectScoreOverviews = iProjectScoreOverviewRepository.findAll(); // Assuming you have a method to fetch all or the relevant subset
            List<ProjectScoreOverviewDTO> projectScoreOverviewDTOList = new ArrayList<>();

            for (ProjectScoreOverview pso : projectScoreOverviews) {
                // map the pso instance attribute values as a dto
                ProjectScoreOverviewDTO projectScoreOverviewDTO = modelMapperUtil.map(pso, ProjectScoreOverviewDTO.class);
                // then we fetch the project info from projects table
                // we are able to call getProject() b/c of concept of lazy loading,due to the One to One mapped by project
                projectScoreOverviewDTO.setProjectId(pso.getProject().getProjectId());
                projectScoreOverviewDTO.setProjectName(pso.getProject().getProjectName());
                projectScoreOverviewDTO.setDateCompleted(pso.getProject().getDateCompleted());
                projectScoreOverviewDTO.setProjectURL(pso.getProject().getProjectURL());
                projectScoreOverviewDTOList.add(projectScoreOverviewDTO);
            }

            return projectScoreOverviewDTOList;


        } catch (Exception e) {
            throw new RuntimeException("Error fetching project score overview list: " + e.getMessage());
        }

    }

    // Capstone Score

    public List<CapstoneScoreDTO> getCapstoneScore() {
        try {
            List<CapstoneScore> capstoneScoreList = iCapstoneScoreRepository.findAll();
            List<CapstoneScoreDTO> capstoneScoreDTOList = new ArrayList<>();
            for (CapstoneScore capstoneScore : capstoneScoreList) {
                capstoneScoreDTOList.add(modelMapperUtil.map(capstoneScore, CapstoneScoreDTO.class));

            }
            return capstoneScoreDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching capstone score list: " + e.getMessage());
        }
    }


    // League App Score

    public List<LeagueAppScoreDTO> getLeagueAppScore() {
        try {
            List<LeagueAppScore> leagueAppScoreList = iLeagueAppScoreRepository.findAll();
            List<LeagueAppScoreDTO> leagueScoreDTOList = new ArrayList<>();
            for (LeagueAppScore leagueAppScore : leagueAppScoreList) {
                leagueScoreDTOList.add(modelMapperUtil.map(leagueAppScore, LeagueAppScoreDTO.class));
            }
            return leagueScoreDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching league app score list: " + e.getMessage());
        }
    }


    // Spring Backend Score
    public List<SpringBackendScoreDTO> getSpringBackendScore() {
        try {
            List<SpringBackendScore> springBackendScoreList = iSpringBackendScoreRepository.findAll();
            List<SpringBackendScoreDTO> springBackendScoreDTOList = new ArrayList<>();
            for (SpringBackendScore springBackendScore : springBackendScoreList) {
                springBackendScoreDTOList.add(modelMapperUtil.map(springBackendScore, SpringBackendScoreDTO.class));
            }
            return springBackendScoreDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching Spring backend score list: " + e.getMessage());
        }
    }
}