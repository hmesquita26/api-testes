package com.testesapi.api_testes.services.exceptions;

public class ObjectOptimisticLockingFailureException extends RuntimeException {

    public ObjectOptimisticLockingFailureException(String message) {
        super(message);
    }
}
