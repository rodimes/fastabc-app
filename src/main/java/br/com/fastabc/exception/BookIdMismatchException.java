package br.com.fastabc.exception;

public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException() {
    }

    public BookIdMismatchException(String message) {
        super(message);
    }

    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
