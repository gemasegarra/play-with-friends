package com.segarra.gamesservice.controller.interfaces;

import com.segarra.gamesservice.model.Game;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface GameController {
    Game createGame(Game newGame);
    List<Game> showAll(@RequestParam (required = false) Optional<String> type, @RequestParam (required = false)
            Optional<String> name);
    Game findGameById(Long id);
    Game updateGame(Game updatedGame,Long id);
    void deleteGame(Long id);

}
