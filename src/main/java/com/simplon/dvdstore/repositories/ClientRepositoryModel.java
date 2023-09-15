package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;//@Id
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name="client")
@Data
@AllArgsConstructor
public class ClientRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
