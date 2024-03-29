package com.vastika.training.capstone.suchanaapi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor

public class ErrorResponse {
    private String errorType;
    private List<ApiError> errors;
}
