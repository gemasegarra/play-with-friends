package com.segarra.edgeserver.classes;

import java.util.List;

public class Match {

    private Long id;
    private String game;
    private Long user;
    private Long numberOfPlayers;
    private List<Long> matches;

    public Match() {
    }

    public Match(String game, Long user, Long numberOfPlayers) {
        this.game = game;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
    }

    public Match(String game, Long user, Long numberOfPlayers, List<Long> matches) {
        this.game = game;
        this.user = user;
        this.numberOfPlayers = numberOfPlayers;
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getMatches() {
        return matches;
    }

    public void setMatches(List<Long> matches) {
        this.matches = matches;
    }
}
