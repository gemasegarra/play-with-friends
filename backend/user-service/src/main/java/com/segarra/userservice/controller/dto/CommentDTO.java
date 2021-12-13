package com.segarra.userservice.controller.dto;

public class CommentDTO {
    private Long friend;
    private String comment;

    public CommentDTO() {
    }

    public CommentDTO(Long friend, String comment) {
        this.friend = friend;
        this.comment = comment;
    }

    public Long getFriendId() {
        return friend;
    }

    public void setFriendId(Long friendId) {
        this.friend = friendId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
