package com.rersdev.eduxpert.config.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;

@Component
public class ExceptionResponse {

    public Object createResponse (Throwable exception, HttpServletRequest request) {
        return ApiError.builder()
                .backMessage(exception.getLocalizedMessage())
                .message(exception.getMessage())
                .url(request.getRequestURL().toString())
                .method(request.getMethod())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public Object createResponse (Throwable exception, HttpServletRequest request, String message) {
        return ApiError.builder()
                .backMessage(exception.getLocalizedMessage())
                .message(message)
                .url(request.getRequestURL().toString())
                .method(request.getMethod())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public Object createResponse (MethodArgumentNotValidException exception, HttpServletRequest request) {
        return ApiError.builder()
                .message(exception.getAllErrors().stream().map(each -> each.getDefaultMessage()).toList().toString())
                .url(request.getRequestURL().toString())
                .method(request.getMethod())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
