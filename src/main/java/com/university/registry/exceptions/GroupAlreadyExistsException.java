package com.university.registry.exceptions;

public class GroupAlreadyExistsException extends RuntimeException {

    public GroupAlreadyExistsException(String groupName) {
        super("Group with this name already exists: " + groupName);
    }
}
