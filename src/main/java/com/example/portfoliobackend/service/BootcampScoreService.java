package com.example.portfoliobackend.service;

import com.example.portfoliobackend.dto.BootcampScoreDTO;
import com.example.portfoliobackend.model.BootcampScore;
import com.example.portfoliobackend.repository.IBootcampScoreRepository;
import com.example.portfoliobackend.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootcampScoreService {
    @Autowired
    IBootcampScoreRepository iBootcampScoreRepository;

    @Autowired
    ModelMapperUtil modelMapperUtil;

    public List<BootcampScoreDTO> getBootcampScoreList() {
        List<BootcampScore> bootcampScoreList = iBootcampScoreRepository.findAll();
        List <BootcampScoreDTO> bootcampScoreDTOList = new ArrayList<>();
        for (BootcampScore bootcampScore: bootcampScoreList) {
            bootcampScoreDTOList.add(modelMapperUtil.map(bootcampScore, BootcampScoreDTO.class));

        }
        return bootcampScoreDTOList;
    }
}
