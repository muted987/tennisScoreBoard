package com.muted987.tennisScoreBoard.service;

import com.muted987.tennisScoreBoard.dao.matchDao.MatchDaoImpl;
import com.muted987.tennisScoreBoard.dto.MatchDto;
import com.muted987.tennisScoreBoard.entity.Match;
import com.muted987.tennisScoreBoard.exceptions.MatchNotFoundException;
import com.muted987.tennisScoreBoard.utils.ExceptionMessageUtil;
import com.muted987.tennisScoreBoard.utils.mapper.MatchMapper;

import java.util.List;

public class FinishedMatchesPersistenceService {

    private final MatchDaoImpl matchDao;

    public FinishedMatchesPersistenceService(MatchDaoImpl matchDao) {
        this.matchDao = matchDao;
    }


    public void saveMatch(MatchDto matchDto) {
        matchDao.save(MatchMapper.toEntity(matchDto).orElseThrow(()-> new MatchNotFoundException(ExceptionMessageUtil.MATCH_NOT_FOUND_MESSAGE)));
    }

    public List<Match> getAllMatches() {
        return matchDao.getAll();
    }
}
