package com.university.registry.advices;

public class ExceptionAdvice {

    public final String message;
    public final int errorCode;
    public final Object data;

    public ExceptionAdvice(String message, int errorCode, Object data) {
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }
}