package com.example.biblioteka.handler;

import com.example.biblioteka.exception.AuthorNotFoundException;
import com.example.biblioteka.exception.BookNotFoundException;
import com.example.biblioteka.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ErrorResponse buildErrorResponse(Exception e, HttpStatus status, HttpServletRequest request) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .url(String.valueOf(request.getRequestURL()))
                .status(status)
                .message(e.getMessage())
                .build();
    }
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBookNotFoundException(BookNotFoundException e, HttpServletRequest request) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e, HttpServletRequest request) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleAuthorNotFoundException(AuthorNotFoundException e, HttpServletRequest request) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        return buildErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
