package com.example.portfoliobackend.controller;

import com.example.portfoliobackend.dto.BootcampScoreDTO;
import com.example.portfoliobackend.dto.ResponseDTO;
import com.example.portfoliobackend.service.BootcampScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bootcampscore")
@CrossOrigin(origins = "*")
public class BootcampScoreController {
    @Autowired
    BootcampScoreService bootcampScoreService;

    /* ------- RETRIEVE -------- */
    @GetMapping
    public ResponseEntity<?> getBootcampScoreList () {
        List<BootcampScoreDTO> bootcampScoreDTOList= bootcampScoreService.getBootcampScoreList();
        ResponseDTO responseDTO = ResponseDTO.builder().hasError(false).data(bootcampScoreDTOList).status(HttpStatus.OK).build();
        return ResponseEntity.ok(responseDTO);

    }


}
