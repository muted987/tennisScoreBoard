package com.muted987.tennisScoreBoard.utils;

import com.muted987.tennisScoreBoard.exceptions.EmptyFieldException;
import lombok.SneakyThrows;

import javax.xml.bind.ValidationException;

public class ValidationUtil {

    public static final String EMPTY_FIELD = "";
    public static final String REGEX_FOR_SYMBOLS_NOT_IN_LATINA_AND_RUSSIAN_LANGUAGES = ".*[^a-zA-Zа-яА-Я\\s].*";

    public static boolean validatePlayersName(String player1Name, String player2Name){
        if (validatePlayerName(player1Name)) {
            return validatePlayerName(player2Name);
        }
        return false;
    }

    public static boolean validatePlayerName(String name){
        if (isNameValid(name)) {
            return isFieldEmpty(name);
        }
        return false;
    }

    @SneakyThrows
    private static boolean isNameValid(String name){
        if (name.matches(REGEX_FOR_SYMBOLS_NOT_IN_LATINA_AND_RUSSIAN_LANGUAGES)){
            throw new ValidationException(ExceptionMessageUtil.BAD_VALIDATION_PLAYER1_NAME_MESSAGE);
        } else {
            return true;
        }
    }

    @SneakyThrows
    private static boolean isFieldEmpty(String name){
        if (name.equals(EMPTY_FIELD)){
            throw new EmptyFieldException(ExceptionMessageUtil.PLAYER1_FIELD_EMPTY);
        } else{
            return true;
        }
    }


}
