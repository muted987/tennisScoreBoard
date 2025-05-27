package com.muted987.tennisScoreBoard.dto;

public enum Points {
    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("AD");

    private final String points;

    Points(String points) {
        this.points = points;
    }

    public String getPoints() {
        return this.points;
    }

    public Points next(){
        return switch(this){
            case ZERO -> FIFTEEN;
            case FIFTEEN -> THIRTY;
            case THIRTY, ADVANTAGE -> FORTY;
            case FORTY -> ADVANTAGE;
        };
    }
}
