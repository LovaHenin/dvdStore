package com.simplon.dvdstorePostgre.services.panierItem;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class PanierItemServiceModel {
    // private Optional<Long> id;
    private Integer  id;
    private Integer  panierId;
    private Integer  dvdId;
    private Float dvdsPrice;
    private Integer  quantity;


    public PanierItemServiceModel() {
    }

//    public PanierItemServiceModel(Long panierId, Long dvdId, Float dvdsPrice, int quantity) {
//        this.panierId = panierId;
//        this.dvdId = dvdId;
//        this.dvdsPrice = dvdsPrice;
//        this.quantity = quantity;
//
//    }

//    public PanierItemServiceModel(Optional<Long> id, Long panierId, Long dvdId, Float dvdsPrice, int quantity) {
//        this.id = id;
//        this.panierId = panierId;
//        this.dvdId = dvdId;
//        this.dvdsPrice = dvdsPrice;
//        this.quantity = quantity;
//    }
}
