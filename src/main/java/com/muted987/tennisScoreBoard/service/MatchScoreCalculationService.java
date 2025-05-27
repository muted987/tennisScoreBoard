package com.muted987.tennisScoreBoard.service;

import com.muted987.tennisScoreBoard.dto.MatchDto;
import com.muted987.tennisScoreBoard.dto.PlayerDto;
import com.muted987.tennisScoreBoard.dto.Points;

public class MatchScoreCalculationService {

    private final int GAMES_TO_WIN = 1;
    private final int SETS_TO_WIN = 1;
    private final int TIE_BREAK_ADVANTAGE = 2;

    public void calculateScore(MatchDto matchDto, int scoredPlayerCode){
        PlayerDto scoredPlayer;
        PlayerDto notScoredPlayer;
        if (scoredPlayerCode == 0) {
            scoredPlayer = matchDto.getPlayer1();
            notScoredPlayer = matchDto.getPlayer2();
        } else {
            scoredPlayer = matchDto.getPlayer2();
            notScoredPlayer = matchDto.getPlayer1();
        }
        if (isSetOver(scoredPlayer.getScore().getGames(), notScoredPlayer.getScore().getGames())){
            scoredPlayer.getScore().resetPoints();
            scoredPlayer.getScore().resetGames();
            notScoredPlayer.getScore().resetPoints();
            notScoredPlayer.getScore().resetGames();
            scoredPlayer.getScore().incrementSets();
        }
        if (isGameOver(scoredPlayer.getScore().getPoints(), notScoredPlayer.getScore().getPoints())) {
            scoredPlayer.getScore().incrementGames();
            scoredPlayer.getScore().resetPoints();
            notScoredPlayer.getScore().resetPoints();
        } else if (isTieBroken(scoredPlayer.getScore().getPoints(), notScoredPlayer.getScore().getPoints())) {
            scoredPlayer.getScore().makePointsDeuceInTieBreak();
            notScoredPlayer.getScore().makePointsDeuceInTieBreak();
        } else {
            scoredPlayer.getScore().incrementPoints();
        }
        if (isMatchOver(scoredPlayer.getScore().getSets(), notScoredPlayer.getScore().getSets())){
            matchDto.setWinner(scoredPlayer);
        }
    }
    private boolean isGameOver(Points scoredPoints, Points notScoredPoints){
        if (scoredPoints.equals(Points.ADVANTAGE) && notScoredPoints.equals(Points.FORTY)) {
            return true;
        }
        return scoredPoints.equals(Points.FORTY) && scoredPoints.ordinal() - notScoredPoints.ordinal() >= TIE_BREAK_ADVANTAGE;
    }
    private boolean isTieBroken(Points scoredPoints, Points notScoredPoints){
        return scoredPoints.equals(Points.FORTY) && notScoredPoints.equals(Points.ADVANTAGE);
    }
    private boolean isSetOver(int scoredGames, int notScoredGames){
        if (scoredGames >= GAMES_TO_WIN) {
            return scoredGames - notScoredGames >= TIE_BREAK_ADVANTAGE;
        }
        return false;
    }

    private boolean isMatchOver(int scoredSets, int notScoredSets){
        return scoredSets == SETS_TO_WIN;
    }
}
