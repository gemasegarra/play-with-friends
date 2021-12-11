package com.segarra.matchingservice.service.impl;

import com.segarra.matchingservice.controller.dto.MatchDTO;
import com.segarra.matchingservice.model.MatchRequest;
import com.segarra.matchingservice.model.MatchUser;
import com.segarra.matchingservice.repository.MatchingRepository;
import com.segarra.matchingservice.repository.UsersMatchedRepository;
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
    @Autowired
    private UsersMatchedRepository usersMatchedRepository;

    @Override
    public MatchRequest createMatchRequest(MatchDTO matchDTO) {
        MatchRequest newMatch = new MatchRequest(matchDTO.getGameId(), matchDTO.getUserId(), matchDTO.getNumberOfPlayers(), matchDTO.getComment());
        matchingRepository.save(newMatch);
        return newMatch;
    }

    @Override
    public void deleteMatch(Long id) {
        MatchRequest match = matchingRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Match does not exist")
        );
        matchingRepository.delete(match);
    }

    @Override
    public MatchRequest updateMatchRequest(Long id, Long match) {
        Optional<MatchRequest> optionalMatch = matchingRepository.findById(id);
        if(optionalMatch.isPresent()) {
            Long players = optionalMatch.get().getNumberOfPlayers();
            List<MatchUser> matchesList = optionalMatch.get().getMatches();
            if(matchesList.isEmpty()) {
                System.out.println("verdad");
            matchesList = new ArrayList<>();
                matchesList.add(new MatchUser(id, match));
                usersMatchedRepository.save(new MatchUser(id, match));
                optionalMatch.get().setMatches(matchesList);
                System.out.println(optionalMatch.get().getMatches());
                System.out.println(matchesList.size() + " lista");

                matchingRepository.save(optionalMatch.get());
            }
            else if(matchesList.size() < players){
                matchesList.add(new MatchUser(id, match));
                optionalMatch.get().setMatches(matchesList);
                usersMatchedRepository.save(new MatchUser(id, match));
                matchingRepository.save(optionalMatch.get());

            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many matches for this request!");
            }return optionalMatch.get();
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found");
    }

    @Override
    public List<MatchRequest> findAll() {
        List<MatchRequest> matches = matchingRepository.findAll();
        System.out.println("foo " + matches.get(0).getMatches().size());
        if(matches.isEmpty()){
            return new ArrayList<>();
        }
        return matches;
    }

    @Override
    public MatchRequest findMatch(Long id) {
        Optional<MatchRequest> optionalMatch = matchingRepository.findById(id);
        if(optionalMatch.isPresent()){
            return optionalMatch.get();
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found");
    }
}
