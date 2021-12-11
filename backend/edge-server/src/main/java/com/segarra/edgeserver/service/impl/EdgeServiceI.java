package com.segarra.edgeserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.segarra.edgeserver.classes.MatchRequest;
import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.client.AuthClient;
import com.segarra.edgeserver.client.GamesClient;
import com.segarra.edgeserver.client.MatchClient;
import com.segarra.edgeserver.client.UserClient;
import com.segarra.edgeserver.controller.dto.*;
import com.segarra.edgeserver.service.interfaces.EdgeService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EdgeServiceI implements EdgeService {

    @Autowired
    private AuthClient authClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private MatchClient matchClient;

    @Autowired
    private GamesClient gamesClient;

    @Override
    public void registerUser(UserAuthDTO user) {
        try {
        UserAuthDTO newUser = new UserAuthDTO (user.getUsername(), user.getEmail(), user.getPassword());
        Long id = userClient.createUser(newUser);
        AuthorizationDTO newAuth = new AuthorizationDTO(id, user.getPassword());
        authClient.registerUser(newAuth);}
        catch (FeignException e){
            throwResponseStatusExceptionFromClient(e);
        }
    }

    @Override
    public void loginUser(LoginDTO request) {
        try {
            Long getId = userClient.findIdByName(request.getUsername());
            AuthorizationDTO user = new AuthorizationDTO(getId, request.getPassword());
            authClient.loginUser(user);
        } catch (FeignException e) {
            throwResponseStatusExceptionFromClient(e);
        }
    }

    @Override
    public void createMatch(MatchInputDTO match) {
        try {
            Long userID = userClient.findIdByName(match.getUser());
            matchClient.createMatchRequest(new MatchServiceDTO(match.getGameId(), userID, match.getNumberOfPlayers(), match.getComment()));
        }
        catch (FeignException e){
            throwResponseStatusExceptionFromClient(e);
        }
    }

    @Override
    public List<MatchOutputDTO> showMatches() {
        List<MatchRequest> matchRequests = matchClient.findAll();
        List<MatchOutputDTO> output = new ArrayList<>();
        for (MatchRequest matchRequest : matchRequests) {
            output.add(convertMatchRequest(matchRequest));
        }
        return output;
    }

    @Override
    public MatchOutputDTO showMatch(Long id) {
        MatchRequest matchRequest = matchClient.findMatch(id);
        return convertMatchRequest(matchRequest);
    }

    private MatchOutputDTO convertMatchRequest(MatchRequest matchRequest) {
        System.out.println("USER " + matchRequest.getUserId());
        User user = userClient.findById(matchRequest.getUserId());
        MatchOutputDTO matchOutput = new MatchOutputDTO(matchRequest.getGameId(), user.getUsername(), matchRequest.getNumberOfPlayers(), matchRequest.getComment());
        List<Long> matchList = matchRequest.getMatches();
        List<String> matches = new ArrayList<>();
        if(matchList == null){
            matchList = new ArrayList<>();
        }
        for (Long matchId : matchList) {
            User matchUser = userClient.findById(matchId);
            matches.add(matchUser.getUsername());
        }
        matchOutput.setMatches(matches);
        return matchOutput;
    }

    @Override
    public void deleteMatch(Long id) {
        matchClient.deleteMatch(id);
    }

    @Override
    public void updateMatch(Long matchingRequestId, String matcherUsername) {
       Long matcherId = userClient.findIdByName(matcherUsername);
       matchClient.updateMatch(matchingRequestId, matcherId);
    }

    public List<GameDTO> showGames() {
        return gamesClient.showAll();
    }


    private void throwResponseStatusExceptionFromClient(FeignException e) {
        JsonParser jsonParser = new JacksonJsonParser();
        Map<String, Object> body = jsonParser.parseMap(e.contentUTF8());
        throw new ResponseStatusException((Integer)body.get("status"), (String)body.get("message"), null);
    }
}
