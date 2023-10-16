package com.simplon.dvdstorePostgre.repositories.panierItem;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@NamedStoredProcedureQuery(
        name = "inserer_dans_panier_items",
        procedureName = "inserer_dans_panier_items",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "panierId"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "dvdId"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "quantity"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Float.class, name = "unitPrice")
        }
)
@Data
public class PanierItemRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Vous pouvez définir un identifiant généré automatiquement
    private Long panierId;
    private Long dvdId;
    private int quantity;
    private Float unitPrice;

    public PanierItemRepositoryModel() {
    }

    public PanierItemRepositoryModel(Long panierId, Long dvdId, int quantity, Float unitPrice) {
        this.panierId = panierId;
        this.dvdId = dvdId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
