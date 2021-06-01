package com.test.car.exception;

public class InvalidCarStateException extends CarException {
    private static final long serialVersionUID = -536561234561231L;

    public InvalidCarStateException() {
    }

    public InvalidCarStateException(String s) {
        super(s);
    }

    public InvalidCarStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCarStateException(Throwable cause) {
        super(cause);
    }
}
