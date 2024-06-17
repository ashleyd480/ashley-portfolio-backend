package com.example.portfoliobackend.repository;

import com.example.portfoliobackend.model.CapstoneScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICapstoneScoreRepository extends JpaRepository <CapstoneScore, Integer> {
}
