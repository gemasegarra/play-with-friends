package com.segarra.userservice.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    @OneToMany(mappedBy = "game")
    @JsonBackReference
    private List<OwnedGame> games;
    @OneToMany(mappedBy = "friendId")
    private List<Friend> friends;
    private String description;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Comment> comments;

    public User(String username, String email, String description) {
        this.username = username;
        this.email = email;
        this.description = description;
    }

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(Long id, String username, String email, List<OwnedGame> games) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.games = games;
    }


    public User(Long id, String username, String email, List<OwnedGame> games, List<Friend> friends) {
        this.id = id;
        this.username = username;
        this.email = email;
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


    public List<OwnedGame> getGames() {
        return games;
    }

    public void setGames(List<OwnedGame> games) {
        this.games = games;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
