package com.segarra.edgeserver.service.interfaces;


import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.controller.dto.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface EdgeService {
    void registerUser(UserAuthDTO user);

    void loginUser(LoginDTO user);

    void createMatch(MatchInputDTO match);

    List<MatchOutputDTO> showMatches(@RequestParam(required = false) Optional<String> user, Optional<String> matcher);

    MatchOutputDTO showMatch(Long id);

    void deleteMatch(Long id);

    void updateMatch(Long matchingRequestId, MatcherDTO matcherUsername);

    List<GameDTO> showGames(@RequestParam(required = false) Optional<String> type, @RequestParam(required = false)
            Optional<String> name);

    GameDTO showGame(Long id);

    Long findIdByName(@RequestParam String username);

    User showUser(@PathVariable Long id);
}
