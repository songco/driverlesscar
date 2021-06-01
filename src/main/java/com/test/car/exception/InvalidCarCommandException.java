package com.test.car.exception;

public class InvalidCarCommandException extends CarException {
    private static final long serialVersionUID = -53656123456123L;

    public InvalidCarCommandException() {
    }

    public InvalidCarCommandException(String s) {
        super(s);
    }

    public InvalidCarCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCarCommandException(Throwable cause) {
        super(cause);
    }
}
