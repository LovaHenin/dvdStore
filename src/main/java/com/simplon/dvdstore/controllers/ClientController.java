package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.ClientService;
import com.simplon.dvdstore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    ClientService clientService ;

    public boolean ajoutClient(@RequestBody ClientDTO clientDTO){

        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO.nom(),clientDTO.adresse());
        return clientService.ajouter(clientServiceModel);


    }



}
