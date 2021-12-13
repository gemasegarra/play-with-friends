package com.segarra.matchingservice.controller.dto;

public class MatcherDTO {
        private Long matcher;

        public MatcherDTO() {
        }

        public MatcherDTO(Long matcher) {
            this.matcher = matcher;
        }

        public Long getMatcher() {
            return matcher;
        }

        public void setMatcher(Long matcher) {
            this.matcher = matcher;
        }
    }


