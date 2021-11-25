package com.segarra.gamesservice.service.impl;

import com.segarra.gamesservice.model.Game;
import com.segarra.gamesservice.repository.GameRepository;
import com.segarra.gamesservice.service.interfaces.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceI implements GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game createGame(Game newGame) {
        Optional<Game> optionalGame = gameRepository.findByName(newGame.getName());
        if(optionalGame.isEmpty()){
            Game createdGame = new Game(newGame.getName(), newGame.getImage(), newGame.getPlatform(), newGame.getType());
            gameRepository.save(createdGame);
            return  createdGame;
        } throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Game with name " + newGame.getName() + " is already registered");
    }

    public List<Game> showAll() {
        List<Game> games = gameRepository.findAll();
        if(games.isEmpty()){
            return new ArrayList<>();
        }
        return gameRepository.findAll();
    }

    @Override
    public Game findGameById(Long id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if(optionalGame.isPresent()){
            return optionalGame.get();
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
    }

    @Override
    public Game updateGame(Game updatedGame, Long id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if(optionalGame.isPresent()){
            optionalGame.get().setName(updatedGame.getName());
            optionalGame.get().setImage(updatedGame.getImage());
            optionalGame.get().setPlatform(updatedGame.getPlatform());
            return updatedGame;
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
    }

    @Override
    public void deleteGame(Long id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        optionalGame.ifPresent(game -> gameRepository.delete(game));
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
    }
}
