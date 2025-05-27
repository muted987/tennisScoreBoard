package com.muted987.tennisScoreBoard.dao.playerDao;

import com.muted987.tennisScoreBoard.entity.Player;

import java.util.Optional;

public interface PlayerDao{

    public void save(String name);

    public Optional<Player> findByName(String name);

}
