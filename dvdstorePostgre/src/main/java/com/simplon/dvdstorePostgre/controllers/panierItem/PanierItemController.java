package com.simplon.dvdstorePostgre.controllers.panierItem;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepositoryModel;
import com.simplon.dvdstorePostgre.services.panierItem.PanierItemService;
import com.simplon.dvdstorePostgre.services.panierItem.PanierItemServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<PanierItemDto> findAll(){
        List<PanierItemServiceModel> panierItemServiceModels=panierItemService.getAll();
        List<PanierItemDto> panierItemDtos =panierItemServiceModels.stream().map((value)->PanierItemMapper.INSTANCE.serviceToDto(value)).collect(Collectors.toList());
        return panierItemDtos;
    }
}
