package com.segarra.edgeserver.service.interfaces;


import com.segarra.edgeserver.controller.dto.*;

import java.util.List;

public interface EdgeService {
    void registerUser(UserAuthDTO user);
    void loginUser(LoginDTO user);
    void createMatch(MatchInputDTO match);
    List<MatchOutputDTO> showMatches();
    MatchOutputDTO showMatch(Long id);
    void deleteMatch(Long id);
    void updateMatch(Long matchingRequestId, String matcherUsername);
    List<GameDTO> showGames();

}
