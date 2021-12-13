package com.segarra.matchingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatchUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long matcher;
    private Long matchingRequest;

    public MatchUser() {
    }

    public MatchUser(Long matcher, Long matchingRequest) {
        this.matcher = matcher;
        this.matchingRequest = matchingRequest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatcher() {
        return matcher;
    }

    public void setMatcher(Long matcher) {
        this.matcher = matcher;
    }

    public Long getMatchingRequest() {
        return matchingRequest;
    }

    public void setMatchingRequest(Long matchingRequest) {
        this.matchingRequest = matchingRequest;
    }
}
