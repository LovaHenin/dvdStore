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
    private Float prix;
    private Integer quantite;

    public DvdServiceModel() {
    }


    public DvdServiceModel(Optional<Long> id, String name, String genre, Float prix, int quantite) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.prix = prix;
        this.quantite = quantite;
    }

    public DvdServiceModel(String name, String genre, Float prix, int quantite) {
        this.name = name;
        this.genre = genre;
        this.prix = prix;
        this.quantite = quantite;
    }
}
