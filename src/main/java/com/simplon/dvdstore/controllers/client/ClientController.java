package com.simplon.dvdstore.controllers.client;

import com.simplon.dvdstore.services.client.ClientService;
import com.simplon.dvdstore.services.client.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import  java.util.Optional;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    ClientService clientService ;
@PostMapping
    public boolean ajoutClient(@RequestBody ClientDTO clientDTO){

        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO.nom(),clientDTO.adresse());
        return clientService.ajouter(clientServiceModel);


    }
    @GetMapping
public List<ClientDTO>  getAll() {
        ArrayList<ClientDTO> clientDTOS = new ArrayList<>();
        ArrayList<ClientServiceModel> clientServiceModels = clientService.getAll();


//        for (ClientServiceModel clientServiceModel : clientServiceModels) {
//
//            clientDTOS.add(new ClientDTO(clientServiceModel.getNom(), clientServiceModel.getAdresse()));
//
//        }
        clientServiceModels.forEach((item)->clientDTOS.add(new ClientDTO(item.getNom(), item.getAdresse())));
        return clientDTOS;

    }
    @GetMapping("/{id}")
public ClientDTO getById (@PathVariable("id") Long id){

    ClientDTO clientDTO = new ClientDTO(clientService.getById(id).get().getNom(),clientService.getById(id).get().getAdresse());
    return  clientDTO;

}

}
