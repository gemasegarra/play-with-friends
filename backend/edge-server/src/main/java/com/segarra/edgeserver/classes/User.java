package com.segarra.edgeserver.classes;



import java.util.Date;
import java.util.List;

public class User {

    private Long id;

    private String username;
    private String email;
    private String platform;
    private List<Long> games;
    private List<Long> friends;

    public User() {
    }

    public User(String username, String email, String platform) {
        this.username = username;
        this.email = email;
        this.platform = platform;
    }

    public User(String username, String email, String platform, List<Long> games) {
        this.username = username;
        this.email = email;
        this.platform = platform;
        this.games = games;
    }

    public User(String username, String email, String platform, List<Long> games, List<Long> friends) {
        this.username = username;
        this.email = email;
        this.platform = platform;
        this.games = games;
        this.friends = friends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<Long> getGames() {
        return games;
    }

    public void setGames(List<Long> games) {
        this.games = games;
    }
}
