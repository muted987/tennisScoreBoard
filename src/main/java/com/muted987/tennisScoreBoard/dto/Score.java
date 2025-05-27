package com.muted987.tennisScoreBoard.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Score {

    private int games = 0;
    private int sets = 0;
    private Points points = Points.ZERO;

    public void resetPoints(){
        setPoints(Points.ZERO);
    }

    public void incrementSets(){
        setSets(getSets() + 1);
    }

    public void incrementGames(){
        setGames(getGames() + 1);
    }

    public void incrementPoints(){
        setPoints(getPoints().next());
    }

    public void endGame(){
        resetPoints();
    }

    public void endSet(){
        resetPoints();
        resetGames();
    }
    public void makePointsDeuceInTieBreak(){
        setPoints(Points.FORTY);
    }
    public void resetGames() {
        setGames(0);
    }
}
