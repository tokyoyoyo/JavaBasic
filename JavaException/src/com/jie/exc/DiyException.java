package com.jie.exc;

public class DiyException extends RuntimeException{
    public DiyException() {
    }

    public DiyException(String message) {
        super(message);
    }

    public DiyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiyException(Throwable cause) {
        super(cause);
    }

    public DiyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
