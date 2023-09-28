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

    public ClientServiceModel() {
    }

    public ClientServiceModel(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public ClientServiceModel(Optional<Long> id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }
}
