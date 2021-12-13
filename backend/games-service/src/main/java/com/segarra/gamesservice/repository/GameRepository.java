package com.segarra.gamesservice.repository;

import com.segarra.gamesservice.enums.Type;
import com.segarra.gamesservice.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByName(String name);
    List<Game> findByType(Type type);
    List<Game> findByNameContaining(String name);


}
