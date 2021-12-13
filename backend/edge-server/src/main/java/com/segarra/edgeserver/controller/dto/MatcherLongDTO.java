package com.segarra.edgeserver.controller.dto;

public class MatcherLongDTO {
    private Long matcher;

    public MatcherLongDTO() {
    }

    public MatcherLongDTO(Long matcher) {
        this.matcher = matcher;
    }

    public Long getMatcher() {
        return matcher;
    }

    public void setMatcher(Long matcher) {
        this.matcher = matcher;
    }
}
