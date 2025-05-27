package com.muted987.tennisScoreBoard.utils.mapper;

import com.muted987.tennisScoreBoard.dto.MatchDto;
import com.muted987.tennisScoreBoard.entity.Match;

import java.util.Optional;

public final class MatchMapper{
    public static Optional<MatchDto> toDto(Match match) {
        return Optional.of(MatchDto.builder()
                        .player1(PlayerMapper.toDto(match.getPlayer1()).orElseThrow(()->new RuntimeException("PlayerNotFound")))
                        .player2(PlayerMapper.toDto(match.getPlayer2()).orElseThrow(()->new RuntimeException("PlayerNotFound")))
                        .winner(PlayerMapper.toDto(match.getWinner()).orElseThrow(()->new RuntimeException("PlayerNotFound")))
                        .build());
    }

    public static Optional<Match> toEntity(MatchDto matchDto) {
        return Optional.of(Match.builder()
                        .player1(PlayerMapper.toEntity(matchDto.getPlayer1()).orElseThrow(()-> new RuntimeException("PlayerNotFound")))
                        .player2(PlayerMapper.toEntity(matchDto.getPlayer2()).orElseThrow(()-> new RuntimeException("PlayerNotFound")))
                        .winner(PlayerMapper.toEntity(matchDto.getWinner()).orElseThrow(()-> new RuntimeException("PlayerNotFound")))
                        .build());
    }
}
