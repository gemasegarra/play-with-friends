package com.segarra.gamesservice.controller.interfaces;

import com.segarra.gamesservice.model.Game;

import java.util.List;

public interface GameController {
    Game createGame(Game newGame);
    List<Game> showAll();
    Game findGameById(Long id);
    Game updateGame(Game updatedGame,Long id);
    void deleteGame(Long id);

}
