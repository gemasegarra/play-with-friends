package com.segarra.edgeserver.controller.dto;

import java.util.List;

public class MatchOutputDTO {
    private String game;
    private String user;
    private Long numberOfPlayers;
    private List<String> matches;

    public MatchOutputDTO() {
    }

    public MatchOutputDTO(String game, String user, Long numberOfPlayers) {
        this.game = game;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
    }

    public MatchOutputDTO(String game, String user, Long numberOfPlayers, List<String> matches) {
        this.game = game;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
        this.matches = matches;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
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
}
