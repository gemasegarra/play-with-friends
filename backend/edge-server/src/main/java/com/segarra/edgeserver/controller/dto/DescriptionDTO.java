package com.segarra.edgeserver.controller.dto;

public class DescriptionDTO {
    private String description;

    public DescriptionDTO() {
    }

    public DescriptionDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
