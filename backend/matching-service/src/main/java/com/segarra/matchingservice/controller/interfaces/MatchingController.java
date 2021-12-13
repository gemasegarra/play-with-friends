package com.segarra.matchingservice.controller.interfaces;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.controller.dto.MatcherDTO;
import com.segarra.matchingservice.model.MatchRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface MatchingController {
    MatchRequest createMatchRequest(MatchDTO matchDTO);

    void deleteMatch(Long id);

    MatchRequest updateMatchRequest(Long id, MatcherDTO match);

    List<MatchRequest> findAll(@RequestParam(required = false) Optional<Long> userId, @RequestParam(required = false) Optional<Long> matcherId);

    MatchRequest findMatch(Long id);
}
