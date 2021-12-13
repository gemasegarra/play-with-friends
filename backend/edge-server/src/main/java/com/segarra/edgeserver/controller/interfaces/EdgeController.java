package com.segarra.edgeserver.controller.interfaces;

import com.segarra.edgeserver.controller.dto.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface EdgeController {
    void registerUser(UserAuthDTO user);

    void loginUser(LoginDTO user);

    void createMatch(MatchInputDTO match);

    List<MatchOutputDTO> showMatches(@RequestParam(required = false) Optional<String> user, @RequestParam(required = false) Optional<String> matcher);

    MatchOutputDTO showMatch(Long id);

    void deleteMatch(Long id);

    void updateMatch(Long id, MatcherDTO matcher);

    List<GameDTO> showAll(@RequestParam(required = false) Optional<String> type, @RequestParam(required = false)
            Optional<String> name);

    GameDTO showGame(Long id);

    Long findIdByName(@RequestParam String username);
}
