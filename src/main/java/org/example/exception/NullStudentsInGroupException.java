package org.example.exception;

public class NullStudentsInGroupException extends CustomException{
    public NullStudentsInGroupException() {
    }

    public NullStudentsInGroupException(String message) {
        super(message);
    }

    public NullStudentsInGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullStudentsInGroupException(Throwable cause) {
        super(cause);
    }

    public NullStudentsInGroupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
