package com.simplon.dvdstore.services.client;

import com.simplon.dvdstore.repositories.client.ClientRepository;
import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public boolean ajouter(ClientServiceModel clientServiceModel) {
        ClientRepositoryModel clientRepositoryModel = new ClientRepositoryModel(clientServiceModel.getNom(),clientServiceModel.getAdresse(),clientServiceModel.getPhoto());
        ClientRepositoryModel clientRepo = clientRepository.save(clientRepositoryModel);

        return clientRepo!=null;
    }

    public ArrayList<ClientServiceModel> getAll(){

        ArrayList<ClientServiceModel> clientServiceModels = new ArrayList<>();
        ArrayList<ClientRepositoryModel> clientRepositoryModels=clientRepository.findAll();
     clientRepositoryModels.forEach((item)-> clientServiceModels.add(new ClientServiceModel(Optional.ofNullable(item.getId()), item.getNom(),item.getAdresse(),item.getPhoto())));
      return clientServiceModels;
    }

    public Optional<ClientServiceModel> getById(Long id) {
        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(id);
        return Optional.of(new ClientServiceModel(Optional.ofNullable(clientRepositoryModel.get().getId()), clientRepositoryModel.get().getNom(), clientRepositoryModel.get().getAdresse(),clientRepositoryModel.get().getPhoto()));

    }
}
