package com.university.registry.advices;

import com.university.registry.exceptions.GroupAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GroupAlreadyExistsAdvice {

    @ResponseBody
    @ExceptionHandler(GroupAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String groupAlreadyExistsHandler(GroupAlreadyExistsException exception) {
        return exception.getMessage();
    }
}
