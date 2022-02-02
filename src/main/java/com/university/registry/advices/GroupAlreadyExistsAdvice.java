package com.university.registry.advices;

import com.university.registry.exceptions.GroupAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GroupAlreadyExistsAdvice {

    @ExceptionHandler(GroupAlreadyExistsException.class)
    ResponseEntity<ExceptionAdvice> groupAlreadyExistsHandler(GroupAlreadyExistsException ex) {
        var res = new ExceptionAdvice(ex.getMessage(), 2, ex.getData());
        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }
}