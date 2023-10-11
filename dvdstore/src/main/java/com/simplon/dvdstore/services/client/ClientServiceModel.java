package com.simplon.dvdstore.services.client;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class ClientServiceModel {

    private Optional<Long> id;
    private String nom;
    private String adresse;
    private String photo;

    public ClientServiceModel() {
    }

    public ClientServiceModel(String nom, String adresse,String photo) {
        this.nom = nom;
        this.adresse = adresse;
        this.photo=photo;
    }

    public ClientServiceModel(Optional<Long> id, String nom, String adresse,String photo) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.photo=photo;
    }
}
