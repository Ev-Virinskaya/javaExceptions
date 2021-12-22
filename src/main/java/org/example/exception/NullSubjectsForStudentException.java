package org.example.exception;

public class NullSubjectsForStudentException extends CustomException{
    public NullSubjectsForStudentException() {
    }

    public NullSubjectsForStudentException(String message) {
        super(message);
    }

    public NullSubjectsForStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullSubjectsForStudentException(Throwable cause) {
        super(cause);
    }

    public NullSubjectsForStudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
