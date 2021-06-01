package com.test.car.exception;

public class CarException extends Exception {
    private static final long serialVersionUID = -53656123456L;

    public CarException() {
    }

    public CarException(String s) {
        super(s);
    }

    public CarException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarException(Throwable cause) {
        super(cause);
    }
}
