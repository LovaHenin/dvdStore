package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.OnDelete;

import java.time.LocalDateTime;

@Entity
@Table(name = "vente")
@Data
public class VenteRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "quantiteVente")
    private Integer quantiteVente;

//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "client_id",nullable = false)
   // @OnDelete()

    private ClientRepositoryModel clientRepositoryModel;

}
