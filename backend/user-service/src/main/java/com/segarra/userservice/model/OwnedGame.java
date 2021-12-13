package com.segarra.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OwnedGame {
    @Id
    @Column(name = "game_name", nullable = false)
    private String game;

    public OwnedGame() {
    }

    public OwnedGame(String game) {
        this.game = game;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
