package com.example.portfoliobackend.service;

import com.example.portfoliobackend.dto.ProjectDetailDTO;
import com.example.portfoliobackend.dto.ProjectForListDTO;
import com.example.portfoliobackend.dto.SkillDTO;
import com.example.portfoliobackend.model.Project;
import com.example.portfoliobackend.model.Skill;
import com.example.portfoliobackend.repository.IProjectRepository;
import com.example.portfoliobackend.repository.ISkillRepository;
import com.example.portfoliobackend.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    IProjectRepository iProjectRepository;

    @Autowired
    ISkillRepository iSkillRepository;

    @Autowired
    ModelMapperUtil modelMapperUtil;


    public List<ProjectForListDTO> getAllProjectResults() {

        try {
            List<Project> allProjectsList = iProjectRepository.findAll();
            List<ProjectForListDTO> allProjectsWithSkills = new ArrayList<>();

            // nested for loop
            /* for each project:
             * create a projectForListDTO to map project info to DTO attributes
             * iterate through the skills for that project and add to the skillDTOs list
             * set skills for that projectsForListDTo as that skillDTOs list
             * add all the projectForListDTO to the main List<ProjectForList> DTO
             */
            for (Project project : allProjectsList) {
                ProjectForListDTO projectForListDTO = modelMapperUtil.map(project, ProjectForListDTO.class);
                List<SkillDTO> skillDTOs = new ArrayList<>();
                for (Skill skill : project.getSkills()) {
                    skillDTOs.add(modelMapperUtil.map(skill, SkillDTO.class));
                }


                projectForListDTO.setSkills(skillDTOs);
                allProjectsWithSkills.add(projectForListDTO);
            }

            return allProjectsWithSkills;

        } catch (Exception e) {
            throw new RuntimeException("Error fetching projects list: " + e.getMessage());
        }
    }

    public ProjectDetailDTO getProjectDetailById(Integer projectId) {
        try {
            Project project = iProjectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found with this projectId" + projectId));
            ProjectDetailDTO projectDetailDTO = modelMapperUtil.map(project, ProjectDetailDTO.class);
            List<SkillDTO> skillDTOs = new ArrayList<>();
            for (Skill skill : project.getSkills()) {
                skillDTOs.add(modelMapperUtil.map(skill, SkillDTO.class));
            }
            projectDetailDTO.setSkills(skillDTOs);

            return projectDetailDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching project detail by id: " + e.getMessage());
        }
    }
}
