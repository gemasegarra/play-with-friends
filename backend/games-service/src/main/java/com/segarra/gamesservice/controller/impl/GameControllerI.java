package com.segarra.gamesservice.controller.impl;

import com.segarra.gamesservice.controller.interfaces.GameController;
import com.segarra.gamesservice.enums.Type;
import com.segarra.gamesservice.model.Game;
import com.segarra.gamesservice.repository.GameRepository;
import com.segarra.gamesservice.service.impl.GameServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class GameControllerI implements GameController {

    @Autowired
    private GameServiceI gameService;

    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game newGame) {
        return gameService.createGame(newGame);
    }


    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> showAll(@RequestParam(required = false) Optional<String> type, @RequestParam(required = false)
            Optional<String> name) {

        if (type.isPresent()) {
            return gameRepository.findByType(Type.valueOf(type.get().toUpperCase()));
        } else if (name.isPresent()) {
            return gameRepository.findByNameContaining(name.get());
        }
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
