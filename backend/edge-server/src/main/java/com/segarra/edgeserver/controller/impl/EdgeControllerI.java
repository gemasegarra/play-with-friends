package com.segarra.edgeserver.controller.impl;

import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.controller.dto.*;
import com.segarra.edgeserver.controller.interfaces.EdgeController;
import com.segarra.edgeserver.service.impl.EdgeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-v1")
@CrossOrigin(value = "http://localhost:4200")
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
    public void loginUser(@RequestBody LoginDTO user) {
        edgeService.loginUser(user);
    }

    @PostMapping("/matching")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMatch(@RequestBody MatchInputDTO match) {
        edgeService.createMatch(match);
    }

    @GetMapping("/matching")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchOutputDTO> showMatches(@RequestParam(required = false) Optional<String> user, @RequestParam(required = false) Optional<String> matcher) {
        return edgeService.showMatches(user, matcher);
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
    public void updateMatch(@PathVariable Long id, @RequestBody MatcherDTO matcher) {
        edgeService.updateMatch(id, matcher);
    }

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> showAll(@RequestParam(required = false) Optional<String> type, @RequestParam(required = false)
            Optional<String> name) {
        return edgeService.showGames(type, name);
    }

    @GetMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameDTO showGame(@PathVariable Long id) {
        return edgeService.showGame(id);
    }

    @GetMapping("/users/id")
    @ResponseStatus(HttpStatus.OK)
    public Long findIdByName(@RequestParam String username) {
        return edgeService.findIdByName(username);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User showUser(@PathVariable Long id) {
        return edgeService.showUser(id);
    }

    @PostMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateUser(@PathVariable Long id, @RequestBody DescriptionDTO description){
        edgeService.updateUser(id, description);
    };

    @PostMapping("/users/{id}/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public String addComment(@PathVariable Long id, @RequestBody CommentDTOInput comment){
        return edgeService.addComment(id, comment);
    };

}
