package com.muted987.tennisScoreBoard.utils.mapper;

import com.muted987.tennisScoreBoard.dto.PlayerDto;
import com.muted987.tennisScoreBoard.dto.Score;
import com.muted987.tennisScoreBoard.entity.Player;

import java.util.Optional;

public final class PlayerMapper {

    public static Optional<PlayerDto> toDto(Player player) {
        return Optional.of(PlayerDto.builder()
                .id(player.getId())
                .name(player.getName())
                .score(new Score())
                .build());
    }

    public static Optional<Player> toEntity(PlayerDto playerDto) {
        return Optional.of(Player.builder()
                .id(playerDto.getId())
                .name(playerDto.getName())
                .build());
    }
}
