package com.simplon.dvdstorePostgre.controllers.panierItem;

import com.simplon.dvdstorePostgre.services.panierItem.PanierItemService;
import com.simplon.dvdstorePostgre.services.panierItem.PanierItemServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("panierItem")
public class PanierItemController {
    @Autowired
    private PanierItemService panierItemService;
    @PostMapping
    public ResponseEntity<String> callProcedureInserePanierItem(@RequestBody PanierItemDto panierItemDto){
        PanierItemServiceModel panierItemServiceModel= PanierItemMapper.INSTANCE.PanierItemDtoToPanierItemService(panierItemDto);
        try {
            panierItemService.insererPanierItem(panierItemServiceModel); // Appel de la procédure stockée
            return new ResponseEntity<>("Panier Item ajouté avec succès", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Gérer l'erreur de manière appropriée
            return new ResponseEntity<>("Échec de l'ajout du Panier Item", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
