package com.simplon.dvdstore.controllers.client;

import com.simplon.dvdstore.services.client.ClientService;
import com.simplon.dvdstore.services.client.ClientServiceModel;
import org.mapstruct.factory.Mappers;
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


    ClientServiceModel clientServiceModel = ClientMapper.INSTANCE.ClientDtoToClientService(clientDTO);

        return clientService.ajouter(clientServiceModel);


    }
    @GetMapping
public List<ClientAfficheDTO>  getAll() {
    ArrayList<ClientAfficheDTO> clientAfficheDTOS = new ArrayList<>();
        //ArrayList<ClientDTO> clientDTOS = new ArrayList<>();
        ArrayList<ClientServiceModel> clientServiceModels = clientService.getAll();


//        for (ClientServiceModel clientServiceModel : clientServiceModels) {
//
//            clientDTOS.add(new ClientDTO(clientServiceModel.getNom(), clientServiceModel.getAdresse()));
//
//        }
        clientServiceModels.forEach((item)->clientAfficheDTOS.add(new ClientAfficheDTO(item.getId().get(), item.getNom(), item.getAdresse(),item.getPhoto())));
        return clientAfficheDTOS;

    }
    @GetMapping("/{id}")
public ClientAfficheDTO getById (@PathVariable("id") Long id){

    ClientAfficheDTO clientAfficheDTO = new ClientAfficheDTO(clientService.getById(id).get().getId().get(),  clientService.getById(id).get().getNom(),clientService.getById(id).get().getAdresse(),clientService.getById(id).get().getPhoto());
    return  clientAfficheDTO;

}

}
