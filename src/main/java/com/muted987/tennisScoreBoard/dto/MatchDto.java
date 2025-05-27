package com.muted987.tennisScoreBoard.dto;


import com.muted987.tennisScoreBoard.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {

    private Long id;
    private PlayerDto player1;
    private PlayerDto player2;
    private PlayerDto winner;


}
