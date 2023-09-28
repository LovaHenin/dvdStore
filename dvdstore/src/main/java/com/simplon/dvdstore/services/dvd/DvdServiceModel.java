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
    private  String synopsis;
    private Float prix;
    private Integer quantite;
    private String photo;

    public DvdServiceModel() {
    }

    public DvdServiceModel(String name, String genre, Float prix, Integer quantite) {
        this.name = name;
        this.genre = genre;
        this.prix = prix;
        this.quantite = quantite;
    }

    /*public DvdServiceModel(Optional<Long> id, String name, String genre, Float prix, int quantite, String photo) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.prix = prix;
        this.quantite = quantite;
        this.photo=photo;

    }*/

    public DvdServiceModel(Optional<Long> id, String name, String genre, String synopsis, Float prix, Integer quantite, String photo) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.synopsis = synopsis;
        this.prix = prix;
        this.quantite = quantite;
        this.photo = photo;
    }

    public DvdServiceModel(String name, String genre, String synopsis, Float prix, Integer quantite, String photo) {
        this.name = name;
        this.genre = genre;
        this.synopsis = synopsis;
        this.prix = prix;
        this.quantite = quantite;
        this.photo = photo;
    }


}
