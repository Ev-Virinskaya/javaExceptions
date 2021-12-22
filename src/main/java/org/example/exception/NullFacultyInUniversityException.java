package org.example.exception;

public class NullFacultyInUniversityException extends CustomException{
    public NullFacultyInUniversityException() {
        super();
    }

    public NullFacultyInUniversityException(String message) {
        super(message);
    }

    public NullFacultyInUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullFacultyInUniversityException(Throwable cause) {
        super(cause);
    }

    protected NullFacultyInUniversityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
