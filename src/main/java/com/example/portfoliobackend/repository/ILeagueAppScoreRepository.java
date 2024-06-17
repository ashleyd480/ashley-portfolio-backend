package com.example.portfoliobackend.repository;

import com.example.portfoliobackend.model.LeagueAppScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeagueAppScoreRepository extends JpaRepository <LeagueAppScore, Integer> {
}
