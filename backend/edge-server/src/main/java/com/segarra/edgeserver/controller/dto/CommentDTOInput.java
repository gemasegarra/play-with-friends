package com.segarra.edgeserver.controller.dto;

public class CommentDTOInput {
    private String friend;
    private String comment;

    public CommentDTOInput() {
    }

    public CommentDTOInput(String friend, String comment) {
        this.friend = friend;
        this.comment = comment;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
