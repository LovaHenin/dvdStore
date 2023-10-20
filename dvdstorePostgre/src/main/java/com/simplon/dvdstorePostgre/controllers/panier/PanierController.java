package com.simplon.dvdstorePostgre.controllers.panier;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierRepository;

import com.simplon.dvdstorePostgre.services.panier.PanierService;
import com.simplon.dvdstorePostgre.services.panier.PanierServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("panier")
public class PanierController {
    @Autowired
    private PanierService panierService;
    @Autowired
    PanierRepository panierRepository;

    //Pour appeler la procedure
    @PatchMapping("/{panierid}")
          public String updateAmount(@PathVariable("panierid") Integer panierId) {
        try {
            return panierRepository.updatePanierAmount(panierId);
        }catch (Exception e) {
            return "Procedure lancée";
        }

    }
    //pour getALL de panier
    @GetMapping
    public List<PanierDto> findAll(){
        List<PanierServiceModel> panierServiceModels = panierService.getAll();
        List<PanierDto> panierDtos =panierServiceModels.stream().map((value)->PanierMapper.INSTANCE.serviToDto(value)).collect(Collectors.toList());
        return panierDtos;
    }



}
