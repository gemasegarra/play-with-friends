package com.segarra.edgeserver.controller.interfaces;

import com.segarra.edgeserver.classes.Match;
import com.segarra.edgeserver.controller.dto.AuthorizationDTO;
import com.segarra.edgeserver.controller.dto.MatchDTO;
import com.segarra.edgeserver.controller.dto.MatchOutputDTO;
import com.segarra.edgeserver.controller.dto.UserAuthDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EdgeController {
    void registerUser(UserAuthDTO user);
    void loginUser(AuthorizationDTO user);
    MatchOutputDTO createMatch(MatchDTO match);
    List<MatchDTO> showMatches();
    MatchOutputDTO showMatch(Long id);
    void deleteMatch(Long id);
    MatchOutputDTO updateMatch(Long id, Long match);

}
