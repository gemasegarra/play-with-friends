package com.segarra.matchingservice.controller.interfaces;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.model.MatchRequest;

import java.util.List;

public interface MatchingController {
    MatchRequest createMatchRequest(MatchDTO matchDTO);
    void deleteMatch(Long id);
    MatchRequest updateMatchRequest(Long id, Long match);
        List<MatchRequest> findAll();
    MatchRequest findMatch(Long id);
}
