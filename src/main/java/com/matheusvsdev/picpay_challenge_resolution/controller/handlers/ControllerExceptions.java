package com.matheusvsdev.picpay_challenge_resolution.controller.handlers;

import com.matheusvsdev.picpay_challenge_resolution.dto.error.CustomError;
import com.matheusvsdev.picpay_challenge_resolution.dto.error.ValidationError;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus http = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(Instant.now()
                ,http.value()
                ,"Dados inválidos"
                ,request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            error.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(http).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now()
                , status.value()
                , e.getMessage()
                , request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ArgumentAlreadyExistsException.class)
    public ResponseEntity<CustomError> handleIllegalArgument(ArgumentAlreadyExistsException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<CustomError> invalidDeposit(InvalidAmountException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> picpayException(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(TransferNotAllowedException.class)
    public ResponseEntity<CustomError> transferException(TransferNotAllowedException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<CustomError> insufficientBalanceException(InsufficientBalanceException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
