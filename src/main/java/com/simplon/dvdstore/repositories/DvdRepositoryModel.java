package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


@Entity
@Table(name = "dvds")
public class DvdRepositoryModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;

    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
