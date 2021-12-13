package com.segarra.edgeserver.controller.dto;

public class MatchInputDTO {
    private Long gameId;
    private String user;
    private Long numberOfPlayers;
    private String comment;

    public MatchInputDTO() {
    }

    public MatchInputDTO(Long gameId, String user, Long numberOfPlayers, String comment) {
        this.gameId = gameId;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
        this.comment = comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}