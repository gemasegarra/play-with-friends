package com.segarra.edgeserver.controller.dto;

public class MatchDTO {
    private Long gameId;
    private String user;
    private Long numberOfPlayers;

    public MatchDTO() {
    }

    public MatchDTO(Long gameId, String user, Long numberOfPlayers) {
        this.gameId = gameId;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Long numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}