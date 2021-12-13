package com.segarra.userservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long friendId;
    private Long user;
    private String comment;

    public Comment() {
    }

    public Comment(Long id, Long friendId, Long user, String comment) {
        this.id = id;
        this.friendId = friendId;
        this.user = user;
        this.comment = comment;
    }

    public Comment(Long friendId, Long user, String comment) {
        this.friendId = friendId;
        this.user = user;
        this.comment = comment;
    }

    public Long getCommentId() {
        return id;
    }

    public void setCommentId(Long commentId) {
        this.id = commentId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

