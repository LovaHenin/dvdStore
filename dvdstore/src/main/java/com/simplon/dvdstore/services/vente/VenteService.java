package com.simplon.dvdstore.services.vente;

import com.simplon.dvdstore.exceptions.ClientNotFoundException;
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
import java.util.Objects;
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

       Optional< DvdRepositoryModel> dvdStoreRepositoryResult=dvdStoreRepository.findById(venteServiceModel.getDvd_id().get());
        // calcul du prix total
        float prixtotal=venteServiceModel.getQuantite()*dvdStoreRepositoryResult.get().getPrix();

       // mise à jour du stock dans la table dvd
        int quantiteStock=dvdStoreRepositoryResult.get().getQuantiteStock()-venteServiceModel.getQuantite();

        // avec get à  la fin au lieu de optional => on reccupere l'objet associé à l'Id
        // sans vérifier si cet enregistrement existe réellement dans la base de données.
        // DvdRepositoryModel dvdRepositoryModel = dvdStoreRepository.findById(venteServiceModel.getDvd_id().get()).get();

        //avec optional soit contient soit l'objet  associé à l'ID recherché
        //(si cet enregistrement existe dans la base de données)
        //soit une valeur Optional.empty() si l'ID n'a pas été trouvé.
        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(venteServiceModel.getClient_id().get());
        // enregistrer la nouvelle quantité dans la base
        dvdStoreRepositoryResult.get().setQuantiteStock(quantiteStock);
        dvdStoreRepository.save(dvdStoreRepositoryResult.get());

        //Optional<ClientRepositoryModel> clientRepositoryResult =clientRepository.findById(venteServiceModel.getClient_id());

        // mapper la venteService en venteRepository
        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel((venteServiceModel.getDate()),venteServiceModel.getQuantite(), prixtotal,clientRepositoryModel.get(),dvdStoreRepositoryResult.get());
                VenteRepositoryModel venteRepositoryModel1=venteRepository.save(venteRepositoryModel);
        return venteRepositoryModel1!=null;
    }

    public ArrayList<VenteServiceModel> getAll() {
       ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();
       ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();


        // stocker les ventes avec les objets
        for(VenteRepositoryModel venteRepositoryModel:venteRepositoryModels){
            //instanciation de DvdServiceModel
            DvdServiceModel dvdServiceModel = new DvdServiceModel(venteRepositoryModel.getDvd().getName(),venteRepositoryModel.getDvd().getGenre(),venteRepositoryModel.getDvd().getPrix(),venteRepositoryModel.getDvd().getQuantiteStock());

            //instanciation de l'objet ClienServiceModel
            ClientServiceModel clientServiceModel = new ClientServiceModel(venteRepositoryModel.getClient().getNom(),venteRepositoryModel.getClient().getAdresse(),venteRepositoryModel.getClient().getPhoto());

            //optional car le champ dvdService est optional dans venteServiceModel
         venteServiceModels.add(new VenteServiceModel(
                 Optional.ofNullable(venteRepositoryModel.getId()),
                 venteRepositoryModel.getDate(),
                venteRepositoryModel.getPrix(),
                venteRepositoryModel.getQuantite(),
                 Optional.of(dvdServiceModel),
                 Optional.of(clientServiceModel)

         ));
        }
        return venteServiceModels;
    }
    public ArrayList<VenteServiceModel> getVenteAllByIdClient(Long id) {
        ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();
        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findByClientId(id);

        //méthode de recherche personnalisée dans le VenteRepository qui récupère directement
        //les ventes associées à un client donné en utilisant son ID.
        //Cela évitera de récupérer toutes les ventes de la base de données et de les filtrer
        /*Optional<ArrayList<VenteRepositoryModel>> venteRepositoryModels = Optional.ofNullable(venteRepository.findByClientId(id));*/


            // stocker les ventes avec les objets
            for (VenteRepositoryModel venteRepositoryModel : venteRepositoryModels) {

                DvdServiceModel dvdServiceModel = new DvdServiceModel(venteRepositoryModel.getDvd().getName(), venteRepositoryModel.getDvd().getGenre(), venteRepositoryModel.getDvd().getPrix(), venteRepositoryModel.getDvd().getQuantiteStock());

                ClientServiceModel clientServiceModel = new ClientServiceModel(venteRepositoryModel.getClient().getNom(), venteRepositoryModel.getClient().getAdresse(),venteRepositoryModel.getClient().getPhoto());

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
