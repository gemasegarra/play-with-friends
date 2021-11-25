package com.segarra.userservice.model;


import com.segarra.userservice.enums.Platform;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    private Platform platform;
    // private List<Long> games;
    // private List<Long> friends;

    public User() {
    }

    public User(String username, String email, Platform platform) {
        this.username = username;
        this.email = email;
        this.platform = platform;
    }

 /*   public User(String username, String email, String platform, List<Long> games) {
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
    }*/

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


    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

 /*   public List<Long> getGames() {
        return games;
    }

    public void setGames(List<Long> games) {
        this.games = games;
    }

    public List<Long> getFriends() {
        return friends;
    }

    public void setFriends(List<Long> friends) {
        this.friends = friends;
    }*/
}
