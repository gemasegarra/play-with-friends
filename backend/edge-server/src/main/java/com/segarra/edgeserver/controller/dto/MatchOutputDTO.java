package com.segarra.edgeserver.controller.dto;

import java.util.List;

public class MatchOutputDTO {
    private Long id;
    private Long gameId;
    private String game;
    private String user;
    private Long numberOfPlayers;
    private List<String> matches;
    private String comment;

    public MatchOutputDTO() {
    }

    public MatchOutputDTO(Long id, Long gameId, String user, Long numberOfPlayers, String comment) {
        this.id = id;
        this.gameId = gameId;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
        this.comment = comment;
    }

    public MatchOutputDTO(Long id, Long gameId, String user, Long numberOfPlayers, List<String> matches, String comment) {
        this.id = id;
        this.gameId = gameId;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
        this.matches = matches;
        this.comment = comment;
    }

    public MatchOutputDTO(Long id, Long gameId, String game, String user, Long numberOfPlayers, String comment) {
        this.id = id;
        this.gameId = gameId;
        this.game = game;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
        this.comment = comment;
    }

    public MatchOutputDTO(Long id, Long gameId, String game, String user, Long numberOfPlayers, List<String> matches, String comment) {
        this.id = id;
        this.gameId = gameId;
        this.game = game;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
        this.matches = matches;
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

    public List<String> getMatches() {
        return matches;
    }

    public void setMatches(List<String> matches) {
        this.matches = matches;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
