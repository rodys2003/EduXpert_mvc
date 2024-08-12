package com.rersdev.eduxpert.config.advice;

import com.rersdev.eduxpert.config.advice.user.InvalidStatusException;
import com.rersdev.eduxpert.config.advice.user.UserAlreadyExistException;
import com.rersdev.eduxpert.config.advice.user.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final  ExceptionResponse response;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response.createResponse(exception,request,"Un error inesperado a ocurrido. Estamos trabajando para resolver el problema."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response.createResponse(exception,request));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotFoundException(UserNotFoundException exception, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.createResponse(exception,request));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> userAlreadyExistException(UserAlreadyExistException exception, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response.createResponse(exception,request));
    }

    @ExceptionHandler(InvalidStatusException.class)
    public ResponseEntity<Object> invalidStatusException(InvalidStatusException exception, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.createResponse(exception,request));
    }
}
