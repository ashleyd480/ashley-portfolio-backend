package com.example.portfoliobackend.repository;

import com.example.portfoliobackend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ISkillRepository extends JpaRepository<Skill, Integer> {
}
