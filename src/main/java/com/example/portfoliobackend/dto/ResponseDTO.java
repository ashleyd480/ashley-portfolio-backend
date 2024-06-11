package com.example.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {
    private Object data;
    private HttpStatus status;
    private String message;
    private String error;
    private Boolean hasError;
}

