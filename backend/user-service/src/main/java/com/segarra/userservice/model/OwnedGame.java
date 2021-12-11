package com.segarra.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OwnedGame {
    @Id
    @Column(name = "game_id", nullable = false)
    private Long gameId;

    public OwnedGame() {
    }

    public OwnedGame(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long id) {
        this.gameId = id;
    }
}
