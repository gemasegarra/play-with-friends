package com.segarra.matchingservice.controller.impl;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.controller.interfaces.MatchingController;
import com.segarra.matchingservice.model.MatchRequest;
import com.segarra.matchingservice.service.impl.MatchingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchingControllerI implements MatchingController {

    @Autowired
    private MatchingServiceI matchingService;

    @PostMapping("/matching")
    @ResponseStatus(HttpStatus.CREATED)
    public MatchRequest createMatchRequest(@RequestBody MatchDTO matchDTO) {
        return matchingService.createMatchRequest(matchDTO);
    }

    @DeleteMapping("/matching/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMatch(@PathVariable Long id) {
        matchingService.deleteMatch(id);
    }

    @PostMapping("/matching/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchRequest updateMatchRequest(@PathVariable Long id, @RequestBody Long match) {
        return matchingService.updateMatchRequest(id, match);
    }

    @GetMapping("/matching")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchRequest> findAll() {
        return matchingService.findAll();
    }

    @GetMapping("/matching/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchRequest findMatch(@PathVariable Long id) {
        return matchingService.findMatch(id);
    }


}
