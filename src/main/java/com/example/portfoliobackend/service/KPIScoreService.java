package com.example.portfoliobackend.service;

import com.example.portfoliobackend.dto.BootcampScoreDTO;
import com.example.portfoliobackend.dto.ProjectScoreOverviewDTO;
import com.example.portfoliobackend.model.BootcampScore;
import com.example.portfoliobackend.model.ProjectScoreOverview;
import com.example.portfoliobackend.repository.IBootcampScoreRepository;
import com.example.portfoliobackend.repository.ICapstoneScoreRepository;
import com.example.portfoliobackend.repository.ILeagueAppScoreRepository;
import com.example.portfoliobackend.repository.IProjectScoreOverviewRepository;
import com.example.portfoliobackend.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KPIScoreService {

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
    ModelMapperUtil modelMapperUtil;

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
}