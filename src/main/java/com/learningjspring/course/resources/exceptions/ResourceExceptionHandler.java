package com.learningjspring.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learningjspring.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //intercepta as exceções que acontecerem
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //Irá interceptar exceções to tipo ResoucerNotFoundException e tratá-las na função
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND; //HTTP ERROR 404 NOT FOUND, STATUS adequado para o erro que vamos tratar

        StandardError stdError = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(stdError);
    }
    
}
