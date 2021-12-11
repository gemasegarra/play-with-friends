package com.segarra.edgeserver.controller.dto;

public class MatchServiceDTO {
    private Long gameId;
    private Long userId;
    private Long numberOfPlayers;
    private String comment;

    public MatchServiceDTO() {
    }

    public MatchServiceDTO(Long gameId, Long userId, Long numberOfPlayers, String comment) {
        this.gameId = gameId;
        this.userId = userId;
        this.numberOfPlayers = numberOfPlayers;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
