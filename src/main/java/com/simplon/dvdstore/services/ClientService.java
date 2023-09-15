package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.ClientRepository;
import com.simplon.dvdstore.repositories.ClientRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public boolean ajouter(ClientServiceModel clientServiceModel) {
        ClientRepositoryModel clientRepositoryModel = new ClientRepositoryModel(clientServiceModel.getNom(),clientServiceModel.getAdresse());
        ClientRepositoryModel clientRepo = clientRepository.save(clientRepositoryModel);

        return clientRepo!=null;
    }
}
