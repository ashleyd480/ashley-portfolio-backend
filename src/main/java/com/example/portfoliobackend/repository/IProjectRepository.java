package com.example.portfoliobackend.repository;

import com.example.portfoliobackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository <Project, Integer> {
}
