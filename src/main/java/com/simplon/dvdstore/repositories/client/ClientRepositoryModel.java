package com.simplon.dvdstore.repositories.client;

import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import jakarta.persistence.*;//@Id
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="client")
@Data
@AllArgsConstructor
public class ClientRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;


    public ClientRepositoryModel() {
    }

    public ClientRepositoryModel(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }
}
