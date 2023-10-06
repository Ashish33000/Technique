package com.technique.exception;

public class TodoException extends RuntimeException{
    public TodoException() {
    }
    public TodoException(String m) {
        super(m);
    }
}
