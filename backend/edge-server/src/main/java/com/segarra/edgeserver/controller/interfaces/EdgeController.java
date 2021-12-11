package com.segarra.edgeserver.controller.interfaces;

import com.segarra.edgeserver.controller.dto.*;


import java.util.List;

public interface EdgeController {
    void registerUser(UserAuthDTO user);
    void loginUser(LoginDTO user);
    void createMatch(MatchInputDTO match);
    List<MatchOutputDTO> showMatches();
    MatchOutputDTO showMatch(Long id);
    void deleteMatch(Long id);
    void updateMatch(Long id, String matcher);
    List<GameDTO> showAll();

}
