package com.simplon.dvdstore.repositories.dvd;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "dvds")
@Data
@AllArgsConstructor
public class DvdRepositoryModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;
    @Column(name = "quantité")
    private Integer quantiteStock;
    @Column(name = "prix")
    private float prix;
    @Column(name="photo")
    private String photo;

    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public DvdRepositoryModel(String name, String genre, Integer quantiteStock, float prix) {
        this.name = name;
        this.genre = genre;
        this.quantiteStock = quantiteStock;
        this.prix = prix;
    }

    public DvdRepositoryModel(String name, String genre , float prix, Integer quantiteStock, String photo) {
        this.name = name;
        this.genre = genre;
        this.quantiteStock = quantiteStock;
        this.prix = prix;
        this.photo=photo;
    }

    public DvdRepositoryModel() {
    }

    public DvdRepositoryModel(Long id, String name, String genre) {
    }


}
