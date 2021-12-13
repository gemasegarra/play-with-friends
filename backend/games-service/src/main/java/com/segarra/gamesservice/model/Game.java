package com.segarra.gamesservice.model;

import com.segarra.gamesservice.enums.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Games must have a name")
    private String name;
    @NotNull(message = "Games must have an image")
    private String image;
    @Column
    @Enumerated
    @ElementCollection(targetClass = Type.class)
    private List<Type> type;
    private String description;

    public Game() {
    }

    public Game(String name, String image, List<Type> type, String description) {
        this.name = name;
        this.image = image;
        this.type = type;
        this.description = description;

    }

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

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
