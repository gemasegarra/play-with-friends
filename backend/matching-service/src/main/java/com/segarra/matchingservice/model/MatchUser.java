package com.segarra.matchingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class MatchUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long matchId;
    private Long matchingRequest;

    public MatchUser() {
    }

    public MatchUser(Long matchId, Long matchingRequest) {
        this.matchId = matchId;
        this.matchingRequest = matchingRequest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getMatchingRequest() {
        return matchingRequest;
    }

    public void setMatchingRequest(Long matchingRequest) {
        this.matchingRequest = matchingRequest;
    }
}
