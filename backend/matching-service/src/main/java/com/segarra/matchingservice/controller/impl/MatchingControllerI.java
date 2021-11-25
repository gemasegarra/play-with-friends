package com.segarra.matchingservice.controller.impl;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.controller.interfaces.MatchingController;
import com.segarra.matchingservice.model.Match;
import com.segarra.matchingservice.service.impl.MatchingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchingControllerI implements MatchingController {

    @Autowired
    private MatchingServiceI matchingService;

    @PostMapping("/matches")
    @ResponseStatus(HttpStatus.CREATED)
    public Match createMatchRequest(@RequestBody MatchDTO matchDTO) {
        return matchingService.createMatchRequest(matchDTO);
    }

    @DeleteMapping("/matches/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMatch(@PathVariable Long id) {
        matchingService.deleteMatch(id);
    }

    @PostMapping("/matches/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Match updateMatchRequest(@PathVariable Long id, @RequestBody Long match) {
        return matchingService.updateMatchRequest(id, match);
    }

    @GetMapping("/matches")
    @ResponseStatus(HttpStatus.OK)
    public List<Match> showAll() {
        return matchingService.showAll();
    }

    @GetMapping("/matches/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Match findMatch(@PathVariable Long id) {
        return matchingService.findMatch(id);
    }


}
