package com.example.portfoliobackend.repository;

import com.example.portfoliobackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository <Project, Integer> {
}
