package com.simplon.dvdstorePostgre.repositories.panierItem;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="panier_items")
public class PanierItemRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Vous pouvez définir un identifiant généré automatiquement
  @Column(name="panier_id")
   private Integer panierId;
    @Column(name="dvd_id")
    private Integer dvdId;
    @Column(name="dvds_price")
    private Float dvdsPrice;
    @Column(name="quantity")
    private Integer quantity;

//    @ManyToOne
//    @JoinColumn(name = "panier_id")
//    private PanierRepositoryModel panier;

    public PanierItemRepositoryModel() {
    }


}
