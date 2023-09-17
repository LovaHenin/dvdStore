package com.simplon.dvdstore.services.dvd;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;


@Data

public class DvdServiceModel {
    private Optional<Long> id;
    private String name;
    private String genre;

    public DvdServiceModel() {
    }

    public DvdServiceModel(Optional<Long> id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public DvdServiceModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
