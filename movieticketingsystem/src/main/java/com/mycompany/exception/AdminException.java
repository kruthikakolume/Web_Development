package com.mycompany.exception;

/**
 *
 * @author kruthikak
 */
public class AdminException extends Exception {

    public AdminException(String message) {
        super(message);
    }

    public AdminException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
