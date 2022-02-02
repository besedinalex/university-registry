package com.university.registry.exceptions;

public class GroupAlreadyExistsException extends RuntimeException {

    private final Object data;

    public GroupAlreadyExistsException(String groupName) {
        super("Group with this name already exists: " + groupName);
        this.data = null;
    }

    public GroupAlreadyExistsException(String groupName, Object data) {
        super("Group with this name already exists: " + groupName);
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}