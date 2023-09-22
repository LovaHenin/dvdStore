package com.simplon.dvdstore.services.vente;

import com.simplon.dvdstore.repositories.client.ClientRepository;
import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import com.simplon.dvdstore.services.client.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VenteService {
    @Autowired
    private VenteRepository venteRepository;
    @Autowired
    private DvdStoreRepository dvdStoreRepository;
    @Autowired
    private ClientRepository clientRepository;

    public boolean add(VenteServiceModel venteServiceModel) {

        Optional<DvdRepositoryModel> dvdStoreRepositoryResult=dvdStoreRepository.findById(venteServiceModel.getDvd_id().get());
        // calcul du prix total
        float prixtotal=venteServiceModel.getQuantite()*dvdStoreRepositoryResult.get().getPrix();

       // mise à jour du stock dans la table dvd
        int quantiteStock=dvdStoreRepositoryResult.get().getQuantiteStock()-venteServiceModel.getQuantite();

        // avec get à  la fin au lieu de optional => on reccupere l'objet
        ClientRepositoryModel clientRepositoryModel = clientRepository.findById(venteServiceModel.getClient_id().get()).get();
        DvdRepositoryModel dvdRepositoryModel = dvdStoreRepository.findById(venteServiceModel.getDvd_id().get()).get();

        dvdRepositoryModel.setQuantiteStock(quantiteStock);
        dvdStoreRepository.save(dvdRepositoryModel);

        //Optional<ClientRepositoryModel> clientRepositoryResult =clientRepository.findById(venteServiceModel.getClient_id());


        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel((venteServiceModel.getDate()),venteServiceModel.getQuantite(), prixtotal,clientRepositoryModel,dvdRepositoryModel);
                VenteRepositoryModel venteRepositoryModel1=venteRepository.save(venteRepositoryModel);
        return venteRepositoryModel1!=null;
    }

    public ArrayList<VenteServiceModel> getAll() {
       ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();
        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();


        // stocker les ventes avec les objets
        for(VenteRepositoryModel venteRepositoryModel:venteRepositoryModels){

            DvdServiceModel dvdServiceModel = new DvdServiceModel(venteRepositoryModel.getDvd().getName(),venteRepositoryModel.getDvd().getGenre(),venteRepositoryModel.getDvd().getPrix(),venteRepositoryModel.getDvd().getQuantiteStock());
            ClientServiceModel clientServiceModel = new ClientServiceModel(venteRepositoryModel.getClient().getNom(),venteRepositoryModel.getClient().getAdresse());

         venteServiceModels.add(new VenteServiceModel(
                 venteRepositoryModel.getDate(),
                venteRepositoryModel.getPrix(),
                venteRepositoryModel.getQuantite(),
                 Optional.of(dvdServiceModel),
                 Optional.of(clientServiceModel)

         ));
        }


        return venteServiceModels;
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
