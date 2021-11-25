package com.segarra.gamesservice.controller.impl;

import com.segarra.gamesservice.controller.interfaces.GameController;
import com.segarra.gamesservice.model.Game;
import com.segarra.gamesservice.service.impl.GameServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameControllerI implements GameController {

    @Autowired
    private GameServiceI gameService;

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game newGame) {
        return gameService.createGame(newGame);
    }

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> showAll() {
        return gameService.showAll();
    }

    @GetMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game findGameById(@PathVariable Long id) {
        return gameService.findGameById(id);
    }

    @PutMapping("/games/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Game updateGame(@RequestBody Game updatedGame, @PathVariable Long id) {
        return gameService.updateGame(updatedGame, id);

    }
    @Override
    public void deleteGame(Long id) {

    }
}
