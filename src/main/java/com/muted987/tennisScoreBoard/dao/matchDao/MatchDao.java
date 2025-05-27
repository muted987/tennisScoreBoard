package com.muted987.tennisScoreBoard.dao.matchDao;

import com.muted987.tennisScoreBoard.entity.Match;

import java.util.List;

public interface MatchDao {

    public void save(Match match);

    public void get(Long id);

    public List<Match> getAll();


}
