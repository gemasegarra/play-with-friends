package com.segarra.matchingservice.service.interfaces;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.model.MatchRequest;

import java.util.List;

public interface MatchingService {
    MatchRequest createMatchRequest(MatchDTO matchDTO);
    void deleteMatch(Long id);
    MatchRequest updateMatchRequest(Long id, Long match);
    List<MatchRequest> findAll();
    MatchRequest findMatch(Long id);


}
