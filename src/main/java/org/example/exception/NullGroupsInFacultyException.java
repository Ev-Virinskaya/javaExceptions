package org.example.exception;

public class NullGroupsInFacultyException extends CustomException{
    public NullGroupsInFacultyException() {
        super();
    }

    public NullGroupsInFacultyException(String message) {
        super(message);
    }

    public NullGroupsInFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullGroupsInFacultyException(Throwable cause) {
        super(cause);
    }

    protected NullGroupsInFacultyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
