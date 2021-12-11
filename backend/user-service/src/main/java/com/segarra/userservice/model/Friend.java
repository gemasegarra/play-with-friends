package com.segarra.userservice.model;

import javax.persistence.*;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long friendId;
    private Long user;
    private String username;

    public Friend() {
    }

    public Friend(Long friendId, Long user, String username) {
        this.friendId = friendId;
        this.user = user;
        this.username = username;
    }

    public Friend(Long friendId, Long user) {
        this.friendId = friendId;
        this.user = user;
    }

    public Friend(Long friendId) {
        this.friendId = friendId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
