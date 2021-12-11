package com.segarra.edgeserver.controller.dto;

import java.util.List;

public class GameDTO {
    private Long id;
    private String name;
    private String image;
    private List<String> type;
    private String description;

    public GameDTO() {
    }

    public GameDTO(Long id, String name, String image, List<String> type, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
        this.description = description;

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

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
