package com.segarra.edgeserver.controller.dto;


import javax.validation.constraints.NotNull;

public class UserAuthDTO {
    @NotNull(message = "User name required")
    private String username;
    @NotNull(message = "Email required")
    private String email;
    @NotNull(message = "Password name required")
    private String password;

    public UserAuthDTO() {
    }


    public UserAuthDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
