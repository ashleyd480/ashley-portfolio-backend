package com.example.portfoliobackend.utils;

import com.example.portfoliobackend.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

// helper method for error handling: if empty list produced from fetch, then we can set the hasError to true to trigger a frontend error message
public class ResponseUtils {
    public static ResponseEntity<?> generateResponse(List<?> dataList) {
        if (dataList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseDTO.builder()
                    .hasError(true)
                    .status(HttpStatus.NO_CONTENT)
                    .build());
        } else {
            return ResponseEntity.ok(ResponseDTO.builder()
                    .hasError(false)
                    .data(dataList)
                    .status(HttpStatus.OK)
                    .build());
        }
    }
}
