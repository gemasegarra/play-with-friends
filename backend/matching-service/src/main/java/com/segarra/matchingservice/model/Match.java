package com.segarra.matchingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "match_table")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String game;
    private Long username;
    private Long numberOfPlayers;
    @OneToMany(mappedBy = "matchId")
    @JsonBackReference
    List<MatchUser> matches = new ArrayList<>();

    public Match() {
    }

    public Match(String game, Long user, Long numberOfPlayers) {
        this.game = game;
        this.username = user;
        this.numberOfPlayers = numberOfPlayers;
    }

     public Match(String game, Long user, Long numberOfPlayers, List<MatchUser> matches) {
        this.game = game;
        this.username = user;
        this.numberOfPlayers = numberOfPlayers;
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Long getUser() {
        return username;
    }

    public void setUser(Long user) {
        this.username = user;
    }

    public Long getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Long numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

   public List<MatchUser> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchUser> matches) {
        this.matches = matches;
    }
}
