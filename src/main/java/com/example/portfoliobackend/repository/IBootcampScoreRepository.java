package com.example.portfoliobackend.repository;

import com.example.portfoliobackend.model.BootcampScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBootcampScoreRepository extends JpaRepository <BootcampScore, Integer> {


}
