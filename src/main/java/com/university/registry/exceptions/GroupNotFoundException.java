package com.university.registry.exceptions;

public class GroupNotFoundException extends RuntimeException {

    private final Object data;

    public GroupNotFoundException(long id) {
        super("Group with this id was not found: " + id);
        this.data = null;
    }

    public GroupNotFoundException(long id, Object data) {
        super("Group with this id was not found: " + id);
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}