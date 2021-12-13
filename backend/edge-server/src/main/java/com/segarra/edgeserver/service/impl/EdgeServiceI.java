package com.segarra.edgeserver.service.impl;

import com.segarra.edgeserver.classes.MatchRequest;
import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.client.*;
import com.segarra.edgeserver.controller.dto.*;
import com.segarra.edgeserver.service.interfaces.EdgeService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Autowired
    private EmailClient emailClient;

    @Override
    public void registerUser(UserAuthDTO user) {
        try {
            UserAuthDTO newUser = new UserAuthDTO(user.getUsername(), user.getEmail(), user.getPassword());
            Long id = userClient.createUser(newUser);
            AuthorizationDTO newAuth = new AuthorizationDTO(id, user.getPassword());
            authClient.registerUser(newAuth);
        } catch (FeignException e) {
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
        } catch (FeignException e) {
            throwResponseStatusExceptionFromClient(e);
        }
    }

    @Override
    public List<MatchOutputDTO> showMatches(@RequestParam(required = false) Optional<String> user, Optional<String> matcher) {
        Optional<Long> userId = user.map(userName -> {
            return userClient.findIdByName(userName);
        });
        Optional<Long> matcherId = matcher.map(matcherName -> {
            return userClient.findIdByName(matcherName);
        });
        List<MatchRequest> matchRequests = matchClient.findAll(userId.orElse(null), matcherId.orElse(null));
        List<MatchOutputDTO> output = new ArrayList<>();
        for (MatchRequest matchRequest : matchRequests) {
            output.add(convertMatchRequest(matchRequest));
        }
        return output;
    }

    @Override
    public MatchOutputDTO showMatch(Long id) {
        MatchRequest matchRequest = matchClient.findMatchRequest(id);
        return convertMatchRequest(matchRequest);
    }

    private MatchOutputDTO convertMatchRequest(MatchRequest matchRequest) {
        User user = userClient.findById(matchRequest.getUserId());
        GameDTO game = gamesClient.findById(matchRequest.getGameId());
        MatchOutputDTO matchOutput = new MatchOutputDTO(matchRequest.getId(), matchRequest.getGameId(), game.getName(), user.getUsername(), matchRequest.getNumberOfPlayers(), matchRequest.getComment());
        List<MatcherLongDTO> matchList = matchRequest.getMatches();
        List<String> matches = new ArrayList<>();
        if (matchList == null) {
            matchList = new ArrayList<>();
        }
        for (MatcherLongDTO matchId : matchList) {
            User matchUser = userClient.findById(matchId.getMatcher());
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
    public void updateMatch(Long matchingRequestId, MatcherDTO matcherUsername) {
        try {
            Long matcherId = userClient.findIdByName(matcherUsername.getMatcher());
            MatcherLongDTO matcher = new MatcherLongDTO(matcherId);
            matchClient.updateMatch(matchingRequestId, matcher);

            MatchRequest matchRequest = matchClient.findMatchRequest(matchingRequestId);
            User user = userClient.findById(matchRequest.getUserId());
            User matcherUser = userClient.findById(matcher.getMatcher());
            GameDTO game = gamesClient.findById(matchRequest.getGameId());
            emailClient.sendMail(new EmailDTO(
                    "no-reply@pwf.es",
                    user.getEmail(),
                    matcherUsername.getMatcher() + " has joined your " + game.getName() + " match!",
                    "<p>Hello <b>" + user.getUsername() + "</b>,</p>" +
                            "<p><b>" + matcherUsername.getMatcher() + "</b> has joined your <b>" + game.getName() + "</b> match!</p>" +
                            "<p>You can contact " + matcherUsername.getMatcher() + " at <a href=\"mailto:" + matcherUser.getEmail() + "\">" + matcherUser.getEmail() + "</a>.</p>" +
                            "<p>Enjoy!</p>"
            ));
        } catch (FeignException e) {
            throwResponseStatusExceptionFromClient(e);
        }
    }

    public List<GameDTO> showGames(@RequestParam(required = false) Optional<String> type, @RequestParam(required = false)
            Optional<String> name) {
        return gamesClient.showAll(type.orElse(null), name.orElse(null));
    }

    @Override
    public GameDTO showGame(Long id) {
        return gamesClient.findById(id);
    }

    public Long findIdByName(@RequestParam String username) {
        return userClient.findIdByName(username);
    }

    public User showUser(@PathVariable Long id) {
        return userClient.findById(id);
    }

    public void updateUser(@PathVariable Long id, @RequestBody DescriptionDTO description){
        userClient.updateUser(id, description);
    };

    public String addComment(@PathVariable Long id, @RequestBody CommentDTOInput comment){
        Long commenterId = userClient.findIdByName(comment.getFriend());
        userClient.addComment(id, new CommentDTO(commenterId, comment.getComment()));
        return comment.getComment();
    };

    private void throwResponseStatusExceptionFromClient(FeignException e) {
        JsonParser jsonParser = new JacksonJsonParser();
        Map<String, Object> body = jsonParser.parseMap(e.contentUTF8());
        throw new ResponseStatusException((Integer) body.get("status"), (String) body.get("message"), null);
    }
}
