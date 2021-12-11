package com.segarra.matchingservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "match_request")
public class MatchRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long gameId;
    private Long userId;
    private Long numberOfPlayers;
    @OneToMany(mappedBy = "matchId", fetch = FetchType.EAGER)
    List<MatchUser> matches;

    public MatchRequest() {
    }


    public MatchRequest(Long gameId, Long userId, Long numberOfPlayers) {
        this.gameId = gameId;
        this.userId = userId;
        this.numberOfPlayers = numberOfPlayers;
    }

    public MatchRequest(Long gameId, Long userId, Long numberOfPlayers, List<MatchUser> matches) {
        this.gameId = gameId;
        this.userId = userId;
        this.numberOfPlayers = numberOfPlayers;
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
