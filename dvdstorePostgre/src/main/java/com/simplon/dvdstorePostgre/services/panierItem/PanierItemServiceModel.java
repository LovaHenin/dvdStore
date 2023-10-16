package com.simplon.dvdstorePostgre.services.panierItem;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class PanierItemServiceModel {
    private Long panierId;
    private Long dvdId;
    private int quantity;
    private Float unitPrice;

    public PanierItemServiceModel() {
    }

    public PanierItemServiceModel(Long panierId, Long dvdId, int quantity, Float unitPrice) {
        this.panierId = panierId;
        this.dvdId = dvdId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
