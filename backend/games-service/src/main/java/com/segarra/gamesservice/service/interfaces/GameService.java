package com.segarra.gamesservice.service.interfaces;

import com.segarra.gamesservice.model.Game;

import java.util.List;

public interface GameService {
    Game createGame(Game newGame);
    List<Game> showAll();
    Game findGameById(Long id);
    Game updateGame(Game updatedGame, Long id);
    void deleteGame(Long id);

}
