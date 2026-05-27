package com.atipera.gitapi25.exception.global;

import com.atipera.gitapi25.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handle(UserNotFoundException ex) {
        return ResponseEntity.status(404).body(
                Map.of(
                        "status", 404,
                        "message", ex.getMessage()
                )
        );
    }
}
