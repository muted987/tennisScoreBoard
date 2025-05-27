package com.muted987.tennisScoreBoard.service;

import com.muted987.tennisScoreBoard.dao.playerDao.PlayerDaoImpl;
import com.muted987.tennisScoreBoard.dto.MatchDto;
import com.muted987.tennisScoreBoard.dto.PlayerDto;
import com.muted987.tennisScoreBoard.entity.Player;
import com.muted987.tennisScoreBoard.exceptions.PlayerNotFoundException;
import com.muted987.tennisScoreBoard.utils.ExceptionMessageUtil;
import com.muted987.tennisScoreBoard.utils.ValidationUtil;
import com.muted987.tennisScoreBoard.utils.mapper.PlayerMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import lombok.SneakyThrows;
import org.hibernate.SessionFactory;

import javax.xml.bind.ValidationException;
import java.util.UUID;


public class NewMatchService {

    private final PlayerDaoImpl playerDao;
    private final OngoingMatchService ongoingMatchService;

    public NewMatchService(OngoingMatchService ongoingMatchService, PlayerDaoImpl playerDao){
        this.playerDao = playerDao;
        this.ongoingMatchService = ongoingMatchService;
    }


    public UUID createMatch(String player1Name, String player2Name) {
        validatePlayers(player1Name, player2Name);
        PlayerDto player1 = PlayerMapper.toDto(getPlayer(player1Name)).orElseThrow(() -> new PlayerNotFoundException(ExceptionMessageUtil.PLAYER_NOT_FOUND_MESSAGE));
        PlayerDto player2 = PlayerMapper.toDto(getPlayer(player2Name)).orElseThrow(() -> new PlayerNotFoundException(ExceptionMessageUtil.PLAYER_NOT_FOUND_MESSAGE));
        MatchDto newMatch = MatchDto.builder().player1(player1).player2(player2).build();
        String uuid = ongoingMatchService.add(newMatch);
        return UUID.fromString(uuid);
    }

    private Player getPlayer(String playerName) {
        return playerDao.findByName(playerName).orElseGet(() -> {
            playerDao.save(playerName);
            return playerDao.findByName(playerName).orElseThrow(() -> new PlayerNotFoundException(ExceptionMessageUtil.PLAYER_NOT_FOUND_MESSAGE));
        });
    }

    private boolean validatePlayers(String player1Name, String player2Name) {
        return ValidationUtil.validatePlayersName(player1Name, player2Name);
    }

}
