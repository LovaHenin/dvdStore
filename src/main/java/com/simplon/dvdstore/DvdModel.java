package com.simplon.dvdstore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@Entity
@Table(name = "dvdmodel")
public class DvdModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String genre;

    public DvdModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
