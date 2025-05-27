package com.muted987.tennisScoreBoard.service;

import com.muted987.tennisScoreBoard.dto.MatchDto;
import com.muted987.tennisScoreBoard.entity.Match;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchService {

    private final Map<String, MatchDto> ongoingMatches;


    public OngoingMatchService() {
        this.ongoingMatches = new ConcurrentHashMap<>();
    }

    public String add(MatchDto match) {
        String uuid = generateUUID();
        while (ongoingMatches.containsKey(uuid)) uuid = generateUUID();
        ongoingMatches.put(uuid, match);
        return uuid;
    }

    public Optional<MatchDto> get(String uuid) {
        return (ongoingMatches.containsKey(uuid)) ? Optional.of(ongoingMatches.get(uuid)) : Optional.empty();
    }
    public void remove(String uuid) {
        ongoingMatches.remove(uuid);
    }
    private static String generateUUID() {
        return UUID.randomUUID().toString();
    }


}
