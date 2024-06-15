package com.pratik.config;

import com.pratik.dto.ErrorResponse;
import com.pratik.dto.ErrorResponse.Explaination;
import com.pratik.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> some(CustomException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                false,
                "some error occurred",
                new Explaination(ex.getMessage()),
                Collections.emptyList()
        );
        return new ResponseEntity<>(errorResponse, ex.getErrorCode());
    }


}

