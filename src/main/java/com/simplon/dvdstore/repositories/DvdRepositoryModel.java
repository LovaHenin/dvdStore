package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "dvds")
@Getter
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
    private BigDecimal prix;

    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public DvdRepositoryModel() {
    }

    public DvdRepositoryModel(Long id, String name, String genre) {
    }
}
