package com.muted987.tennisScoreBoard.exceptions;

public class MatchNotFoundException extends RuntimeException{

    public MatchNotFoundException(String message){
        super(message);
    }

}
