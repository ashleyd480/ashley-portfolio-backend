package com.example.portfoliobackend.service;

import com.example.portfoliobackend.dto.ProjectDetailDTO;
import com.example.portfoliobackend.dto.ProjectForListDTO;
import com.example.portfoliobackend.dto.SkillDTO;
import com.example.portfoliobackend.model.Project;
import com.example.portfoliobackend.model.Skill;
import com.example.portfoliobackend.repository.IProjectRepository;
import com.example.portfoliobackend.repository.ISkillRepository;
import com.example.portfoliobackend.utils.ModelMapperUtil;
import org.hibernate.Hibernate;
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

public List<ProjectForListDTO> getAllProjectResults () {

    List<Project> allProjectsList = iProjectRepository.findAll();
    List<ProjectForListDTO> allProjectsWithSkills = new ArrayList<>();

    for (Project project : allProjectsList) {
//        Hibernate.initialize(project.getSkills());
// Ensure collection is initialized

        ProjectForListDTO projectForListDTO = modelMapperUtil.map(project, ProjectForListDTO.class);
        List<SkillDTO> skillDTOs = new ArrayList<>();
        for (Skill skill : project.getSkills()) {
            skillDTOs.add(modelMapperUtil.map(skill, SkillDTO.class));
        }

        projectForListDTO.setSkills(skillDTOs);
        allProjectsWithSkills.add(projectForListDTO);
    }

    return allProjectsWithSkills;

}

//    public List<ProjectDetailtDTO> getProjectDetailById(String projectName) {
//        System.out.println(hello);
//        return List< ProjectDetailDTO > list
//    }
}
