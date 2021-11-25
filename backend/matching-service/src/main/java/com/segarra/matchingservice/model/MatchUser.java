package com.segarra.matchingservice.model;

import javax.persistence.*;

@Entity
public class MatchUser {
    @Id
    @Column(name = "id", nullable = false)
    private Long userId;
    private Long matchId;

    public MatchUser() {
    }

    public MatchUser(Long userId, Long matchId) {
        this.userId = userId;
        this.matchId = matchId;
    }

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
}
