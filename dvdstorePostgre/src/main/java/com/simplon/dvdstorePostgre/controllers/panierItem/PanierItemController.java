package com.simplon.dvdstorePostgre.controllers.panierItem;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepositoryModel;
import com.simplon.dvdstorePostgre.services.panierItem.PanierItemService;
import com.simplon.dvdstorePostgre.services.panierItem.PanierItemServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("panieritem")
public class PanierItemController {
    @Autowired
    private PanierItemService panierItemService;
    @PostMapping
    public boolean insererPanierItems(@RequestBody PanierItemDto panierItemDto){
        PanierItemServiceModel panierItemServiceModel= PanierItemMapper.INSTANCE.DtoToservice(panierItemDto);
       return panierItemService.insererPanierItem(panierItemServiceModel);
    }
}
