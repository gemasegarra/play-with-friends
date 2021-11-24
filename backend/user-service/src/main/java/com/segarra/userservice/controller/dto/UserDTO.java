package com.segarra.userservice.controller.dto;

import java.util.List;

public class UserDTO {
    private String username;
    private String email;
    private String platform;

    public UserDTO() {
    }

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserDTO(String username, String email, String platform) {
        this.username = username;
        this.email = email;
        this.platform = platform;
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
}
