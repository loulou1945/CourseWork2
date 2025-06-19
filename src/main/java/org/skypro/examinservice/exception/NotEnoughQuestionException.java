package org.skypro.examinservice.exception;

public class NotEnoughQuestionException extends RuntimeException {
    public NotEnoughQuestionException(String message) {
        super(message);
    }
}
