package com.segarra.edgeserver.controller.dto;

public class MatcherDTO {
    private String matcher;

    public MatcherDTO() {
    }

    public MatcherDTO(String matcher) {
        this.matcher = matcher;
    }

    public String getMatcher() {
        return matcher;
    }

    public void setMatcher(String matcher) {
        this.matcher = matcher;
    }
}
