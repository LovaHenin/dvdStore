package com.simplon.dvdstore.services.vente;

import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.vente.VenteRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;

public class VenteService {
    @Autowired
    private VenteRepository venteRepository;

    public boolean add(VenteServiceModel venteServiceModel) {
        // float prix,int quantite,Long dvd_id,Long client_id
        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(venteServiceModel.getPrix(),venteServiceModel.getQuantite(),venteServiceModel.getDvd_id(),venteServiceModel.getClient_id());
                VenteRepositoryModel venteRepositoryModel1=venteRepository.save(venteRepositoryModel);
        return true;
    }

//    public ArrayList<VenteServiceModel> getAllById(Long clientId){
//
//        ArrayList<VenteServiceModel>venteServiceModels = new ArrayList<>();
//        ArrayList<VenteRepositoryModel>venteRepositoryModels = (ArrayList<VenteRepositoryModel>) venteRepository.findAllById(Collections.singleton(clientId));
//
//
//        return venteServiceModels;
//    }

//    public boolean add(VenteServiceModel venteServiceModel) {
//        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(venteServiceModel.getDate(),venteServiceModel.getPrix());
//
//        VenteRepositoryModel venteRepositoryModel1=venteRepository.save(venteRepositoryModel);
//        return venteRepositoryModel1!=null;
//    }
}
