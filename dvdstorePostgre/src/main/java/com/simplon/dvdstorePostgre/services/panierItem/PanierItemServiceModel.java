package com.simplon.dvdstorePostgre.services.panierItem;

import com.simplon.dvdstorePostgre.services.panier.PanierServiceModel;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class PanierItemServiceModel {
    private Integer id;
    private Integer  dvdId;
    private Float dvdsPrice;
    private Integer  quantity;
    private PanierServiceModel panier;
//    private Integer  panierId;


    public PanierItemServiceModel() {
    }


}
