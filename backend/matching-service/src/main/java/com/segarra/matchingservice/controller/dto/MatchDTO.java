package com.segarra.matchingservice.controller.dto;

import java.util.List;

public class MatchDTO {
    private String game;
    private Long user;
    private Long numberOfPlayers;

    public MatchDTO() {
    }

    public MatchDTO(String game, Long user, Long numberOfPlayers) {
        this.game = game;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Long numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
