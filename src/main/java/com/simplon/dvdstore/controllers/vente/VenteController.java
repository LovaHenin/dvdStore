package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.exceptions.ResourceNotFoundException;
import com.simplon.dvdstore.repositories.client.ClientRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import com.simplon.dvdstore.services.vente.VenteService;
import com.simplon.dvdstore.services.vente.VenteServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VenteController {
//    @Autowired
//    private ClientRepository clientRepository;
//    @Autowired
//    private VenteRepository venteRepository;
    @Autowired
    private VenteService venteService;

    @PutMapping
    public boolean addVente(@RequestBody VenteDTO venteDTO){
        // float prix,int quantite,Long dvd_id,Long client_id
        VenteServiceModel venteServiceModel=new VenteServiceModel(venteDTO.prix(),venteDTO.quantite(),venteDTO.dvd_id(),venteDTO.client_id());
        return venteService.add(venteServiceModel);
    }
//    @GetMapping("/{clientId}")
//    public List<VenteDTO> getAllVentesByClientId(@PathVariable(value="clientId") Long clientId){
//
//        ArrayList<VenteDTO>venteDTOS = new ArrayList<>();
//        ArrayList<VenteServiceModel> venteServiceModels =venteService.getAllById(clientId);
//
//      return venteDTOS;
//    }

}
