package com.segarra.edgeserver.service.impl;

import com.segarra.edgeserver.classes.Match;
import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.client.AuthClient;
import com.segarra.edgeserver.client.MatchClient;
import com.segarra.edgeserver.client.UserClient;
import com.segarra.edgeserver.controller.dto.AuthorizationDTO;
import com.segarra.edgeserver.controller.dto.MatchDTO;
import com.segarra.edgeserver.controller.dto.MatchOutputDTO;
import com.segarra.edgeserver.controller.dto.UserAuthDTO;
import com.segarra.edgeserver.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeServiceI implements EdgeService {

    @Autowired
    private AuthClient authClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private MatchClient matchClient;

    @Override
    public void registerUser(UserAuthDTO user) {
        UserAuthDTO newUser = new UserAuthDTO (user.getUsername(), user.getEmail(), user.getPassword());
        Long id = userClient.createUser(newUser);
        AuthorizationDTO newAuth = new AuthorizationDTO(id, user.getPassword());
        authClient.registerUser(newAuth);
    }

    @Override
    public void loginUser(AuthorizationDTO user) {

        authClient.loginUser(user);

    }

    @Override
    public MatchOutputDTO createMatch(MatchDTO match) {
        User user = userClient.findById(match.getUser());
        matchClient.createMatchRequest(match);
        return new MatchOutputDTO(match.getGame(), user.getUsername(), match.getNumberOfPlayers());
    }

    @Override
    public List<MatchDTO> showMatches() {
        return matchClient.showAll();
    }

    @Override
    public MatchOutputDTO showMatch(Long id) {
        Match match = matchClient.findMatch(id);
        User user = userClient.findById(match.getUser());
        return new MatchOutputDTO(match.getGame(), user.getUsername(), match.getNumberOfPlayers());
    }

    @Override
    public void deleteMatch(Long id) {
        matchClient.deleteMatch(id);
    }

    @Override
    public MatchOutputDTO updateMatch(Long id, Long match) {
        Match matchRequest = matchClient.findMatch(id);
        User owner = userClient.findById(matchRequest.getId());
        User matcher = userClient.findById(match);
        matchClient.updateMatch(id, match);
        MatchOutputDTO matchOutput = new MatchOutputDTO(matchRequest.getGame(), owner.getUsername(), matchRequest.getNumberOfPlayers());
        List<String> matches = matchOutput.getMatches();
        matches.add(matcher.getUsername());
        return matchOutput;
    }
}
