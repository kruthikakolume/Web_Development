package com.mycompany.exception;

/**
 *
 * @author kruthikak
 */
public class MovieException extends Exception {

    public MovieException(String message) {
        super(message);
    }

    public MovieException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
