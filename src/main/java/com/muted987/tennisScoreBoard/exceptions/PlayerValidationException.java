package com.muted987.tennisScoreBoard.exceptions;

public class PlayerValidationException extends RuntimeException {
    public PlayerValidationException(String message) {
        super(message);
    }
}