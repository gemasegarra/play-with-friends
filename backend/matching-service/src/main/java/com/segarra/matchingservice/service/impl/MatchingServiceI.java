package com.segarra.matchingservice.service.impl;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.model.Match;
import com.segarra.matchingservice.model.MatchUser;
import com.segarra.matchingservice.repository.MatchingRepository;
import com.segarra.matchingservice.service.interfaces.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchingServiceI implements MatchingService {

    @Autowired
    private MatchingRepository matchingRepository;


    @Override
    public Match createMatchRequest(MatchDTO matchDTO) {
        Match newMatch = new Match(matchDTO.getGame(), matchDTO.getUser(), matchDTO.getNumberOfPlayers());
        matchingRepository.save(newMatch);
        return newMatch;
    }

    @Override
    public void deleteMatch(Long id) {
        Match match = matchingRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Match does not exist")
        );
        matchingRepository.delete(match);
    }

    @Override
    public Match updateMatchRequest(Long id, Long match) {
        Optional<Match> optionalMatch = matchingRepository.findById(id);
        if(optionalMatch.isPresent()) {
            Long players = optionalMatch.get().getNumberOfPlayers();
            List<MatchUser> matchesList = optionalMatch.get().getMatches();
            if(matchesList.isEmpty()) {
                System.out.println("verdad");
            matchesList = new ArrayList<>();
                matchesList.add(new MatchUser(id, match));
            }
            else if(matchesList.size() < players){
                matchesList.add(new MatchUser(id, match));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many matches for this request!");
            }return optionalMatch.get();
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found");
    }

    @Override
    public List<Match> showAll() {
        List<Match> matches = matchingRepository.findAll();
        if(matches.isEmpty()){
            return new ArrayList<>();
        } return matches;
    }

    @Override
    public Match findMatch(Long id) {
        Optional<Match> optionalMatch = matchingRepository.findById(id);
        if(optionalMatch.isPresent()){
            return optionalMatch.get();
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found");
    }
}
