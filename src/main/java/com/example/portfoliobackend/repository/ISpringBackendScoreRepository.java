package com.example.portfoliobackend.repository;

import com.example.portfoliobackend.model.SpringBackendScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpringBackendScoreRepository extends JpaRepository <SpringBackendScore, Integer> {

}
