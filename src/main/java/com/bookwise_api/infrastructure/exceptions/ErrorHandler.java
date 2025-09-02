package com.bookwise_api.infrastructure.exceptions;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatedBook(DataIntegrityViolationException ex, HttpServletRequest request) {

        var error = new ErrorResponse(
                LocalDateTime.now(),
                409,
                "Conflict",
                "Book already registered in the database!",
                request.getRequestURI()
        );

        return ResponseEntity.status(409).body(error);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(EntityNotFoundException ex, HttpServletRequest request) {

        var error = new ErrorResponse(
                LocalDateTime.now(),
                404,
                "Entity not found",
                ex.getMessage(),
                request.getRequestURI()
                );

        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(NoFieldsToUpdateException.class)
    public ResponseEntity<ErrorResponse> handleNoFields(NoFieldsToUpdateException ex, HttpServletRequest request) {
        var error = new ErrorResponse(
                LocalDateTime.now(),
                400,
                "Bad Request",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(error);
    }



}
