package com.simplon.dvdstorePostgre.repositories.panierItem;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="panier")
public class PanierRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="amount",columnDefinition = "REAL")
    private Float amount;
    @Column(name="client_id")
    private int clientId;

//    @OneToMany(mappedBy = "panier", orphanRemoval = true)
//    private List<PanierItemRepositoryModel> paniers = new ArrayList<>();

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}

