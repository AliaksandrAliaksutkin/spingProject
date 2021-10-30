package org.example.exception;

public class NoEntityException extends RuntimeException {
    public NoEntityException(Long message) {
        super(String.valueOf(message));
    }
}
