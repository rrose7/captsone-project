package com.vastika.training.capstone.suchanaapi.exceptions.handler;


import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.ApiError;
import com.vastika.training.capstone.suchanaapi.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SuchanaApiException.class)
    public ResponseEntity<ErrorResponse> handleSuchanaApiException(SuchanaApiException apiException){
        String message = apiException.getMessage();
        int code = apiException.getCode();

        ApiError apiError = new ApiError(message, code);
        List<ApiError> errors = new ArrayList<>();
        errors.add(apiError);

        ErrorResponse response = new ErrorResponse("Suchan API ERROR!", errors);
        return new ResponseEntity<>(response, HttpStatus.resolve(code));
    }
}
