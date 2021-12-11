package com.segarra.edgeserver.classes;

import java.util.List;

public class MatchRequest {

    private Long id;
    private Long gameId;
    private Long userId;
    private Long numberOfPlayers;
    private List<Long> matches;

    public MatchRequest() {
    }

    public MatchRequest(Long gameId, Long userId, Long numberOfPlayers) {
        this.gameId = gameId;
        this.userId = userId;
        this.numberOfPlayers = numberOfPlayers;
    }

    public MatchRequest(Long gameId, Long userId, Long numberOfPlayers, List<Long> matches) {
        this.gameId = gameId;
        this.userId = userId;
        this.numberOfPlayers = numberOfPlayers;
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Long numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public List<Long> getMatches() {
        return matches;
    }

    public void setMatches(List<Long> matches) {
        this.matches = matches;
    }
}
