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

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("vente")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @PostMapping
    public boolean addVente(@RequestBody VenteDTO venteDTO){
        //String date, int quantite,Long dvd_id,Long client_id
        VenteServiceModel venteServiceModel=new VenteServiceModel(LocalDate.parse(venteDTO.date()),venteDTO.quantite(),venteDTO.dvd_id(),venteDTO.client_id());
        return venteService.add(venteServiceModel);
    }


}
