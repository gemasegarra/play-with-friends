package com.segarra.edgeserver.classes;

import com.segarra.edgeserver.controller.dto.MatcherLongDTO;

import java.util.List;

public class MatchRequest {

    private Long id;
    private Long gameId;
    private Long userId;
    private Long numberOfPlayers;
    private List<MatcherLongDTO> matches;
    private String comment;

    public MatchRequest() {
    }

    public MatchRequest(Long gameId, Long userId, Long numberOfPlayers, String comment) {
        this.gameId = gameId;
        this.userId = userId;
        this.numberOfPlayers = numberOfPlayers;
        this.comment = comment;

    }

    public MatchRequest(Long gameId, Long userId, Long numberOfPlayers, List<MatcherLongDTO> matches, String comment) {
        this.gameId = gameId;
        this.userId = userId;
        this.numberOfPlayers = numberOfPlayers;
        this.matches = matches;
        this.comment = comment;

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

    public List<MatcherLongDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatcherLongDTO> matches) {
        this.matches = matches;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
