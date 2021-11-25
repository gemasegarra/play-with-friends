package com.segarra.matchingservice.service.interfaces;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.model.Match;

import java.util.List;

public interface MatchingService {
    Match createMatchRequest(MatchDTO matchDTO);
    void deleteMatch(Long id);
    Match updateMatchRequest(Long id, Long match);
    List<Match> showAll();
    Match findMatch(Long id);


}
