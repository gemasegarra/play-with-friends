package com.segarra.edgeserver.controller.impl;

import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.controller.dto.AuthorizationDTO;
import com.segarra.edgeserver.controller.dto.MatchDTO;
import com.segarra.edgeserver.controller.dto.MatchOutputDTO;
import com.segarra.edgeserver.controller.dto.UserAuthDTO;
import com.segarra.edgeserver.controller.interfaces.EdgeController;
import com.segarra.edgeserver.service.impl.EdgeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-v1")
public class EdgeControllerI implements EdgeController {

    @Autowired
    private EdgeServiceI edgeService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserAuthDTO user) {
        edgeService.registerUser(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
        public void loginUser(@RequestBody AuthorizationDTO user) {
        edgeService.loginUser(user);
    }

    @PostMapping("/matching")
    @ResponseStatus(HttpStatus.CREATED)
    public MatchOutputDTO createMatch(@RequestBody MatchDTO match) {
        return edgeService.createMatch(match);
    }

    @GetMapping("/matching")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchDTO> showMatches() {
        return edgeService.showMatches();
    }

    @GetMapping("/matching/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchOutputDTO showMatch(@PathVariable Long id) {
        return edgeService.showMatch(id);
    }

    @DeleteMapping("/matching/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMatch(@PathVariable Long id) {
        edgeService.deleteMatch(id);
    }

    @PostMapping("/matching/{id}")
    public MatchOutputDTO updateMatch(@PathVariable Long id, @RequestBody Long match) {
        return edgeService.updateMatch(id, match);
    }
}
