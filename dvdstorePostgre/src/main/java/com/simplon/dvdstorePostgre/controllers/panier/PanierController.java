package com.simplon.dvdstorePostgre.controllers.panier;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/panier")
public class PanierController {
    @Autowired
   // private PanierService panierService;
    PanierRepository panierRepository;

    @PatchMapping("/{panierid}")
          public String updateAmount(@PathVariable("panierid") Integer panierId) {
        try {
            return panierRepository.updatePanierAmount(panierId);
        }catch (Exception e) {
            return "Procedure lancée";
        }

    }
}
