package com.example.crud_api.exception;


import com.example.crud_api.response.Response;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;



@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundException(ProductNotFoundException pNotFoundException) {
        return new ResponseEntity<>(new Response("User is not found.", HttpStatus.NOT_FOUND, null), HttpStatus.NOT_FOUND              );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validationError(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> constraintViolationSet = constraintViolationException.getConstraintViolations();
        Map<String, String> errorMap = new HashMap<String, String>();

        for(ConstraintViolation cv : constraintViolationSet) {
            logger.info(cv.getPropertyPath() +"="+cv.getMessage());
            errorMap.put(cv.getPropertyPath().toString(), cv.getMessage());

        }

        return new ResponseEntity<>(new Response("Error in data.", HttpStatus.BAD_REQUEST, errorMap), HttpStatus.BAD_REQUEST);
    }
    }

