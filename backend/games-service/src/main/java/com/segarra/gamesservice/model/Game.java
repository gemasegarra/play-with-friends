package com.segarra.gamesservice.model;

import com.segarra.gamesservice.enums.Platform;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Games must have a name")
    private String name;
    @NotNull(message= "Games must have an image")
    private String image;
    @Enumerated(value = EnumType.STRING)
    private Platform platform;
    private String type;
    private String rating;
    // private List<Comment> comments;

    public Game() {
    }

    public Game(String name, String image, Platform platform, String type) {
        this.name = name;
        this.image = image;
        this.platform = platform;
        this.type = type;
    }

   /* public Game(String name, String image, Platform platform, String type, String rating, List<String> comments) {
        this.name = name;
        this.image = image;
        this.platform = platform;
        this.type = type;
        this.rating = rating;
        this.comments = comments;
    } */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

   /* public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    } */
}
