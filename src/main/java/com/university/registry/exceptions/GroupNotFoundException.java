package com.university.registry.exceptions;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(long id) {
        super("Group with this id was not found: " + id);
    }
}
