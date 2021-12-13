package com.segarra.matchingservice.controller.impl;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.controller.dto.MatcherDTO;
import com.segarra.matchingservice.controller.interfaces.MatchingController;
import com.segarra.matchingservice.model.MatchRequest;
import com.segarra.matchingservice.repository.MatchingRepository;
import com.segarra.matchingservice.service.impl.MatchingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MatchingControllerI implements MatchingController {

    @Autowired
    private MatchingServiceI matchingService;

    @Autowired
    private MatchingRepository matchingRepository;

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
    public MatchRequest updateMatchRequest(@PathVariable Long id, @RequestBody MatcherDTO match) {
        return matchingService.updateMatchRequest(id, match);
    }

    @GetMapping("/matching")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchRequest> findAll(@RequestParam (required = false) Optional<Long> userId, @RequestParam (required = false) Optional<Long> matcherId) {
        if (matcherId.isPresent()) {
            return matchingRepository.findByMatcherId(matcherId.get());
        } else if(userId.isPresent()){
            return matchingRepository.findByUserId(userId.get());
        }
        return matchingService.findAll();
    }

    @GetMapping("/matching/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchRequest findMatch(@PathVariable Long id) {
        return matchingService.findMatch(id);
    }

}
