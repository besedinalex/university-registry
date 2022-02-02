package com.university.registry.advices;

import com.university.registry.exceptions.GroupNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GroupNotFoundAdvice {

    @ExceptionHandler(GroupNotFoundException.class)
    ResponseEntity<ExceptionAdvice> groupNotFoundHandler(GroupNotFoundException ex) {
        var res = new ExceptionAdvice(ex.getMessage(), 1, ex.getData());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}