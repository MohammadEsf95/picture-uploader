package com.example.demo.infrastructure.exception.applicationexception;

public class RecordNotFoundException extends BaseApplicationException {

    public RecordNotFoundException(String message) {
        super(message);
    }
}
