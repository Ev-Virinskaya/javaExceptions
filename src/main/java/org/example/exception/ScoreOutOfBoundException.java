package org.example.exception;

public class ScoreOutOfBoundException extends CustomException{
    public ScoreOutOfBoundException() {
    }

    public ScoreOutOfBoundException(String message) {
        super(message);
    }

    public ScoreOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScoreOutOfBoundException(Throwable cause) {
        super(cause);
    }

    public ScoreOutOfBoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
